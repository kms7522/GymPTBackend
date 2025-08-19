package com.Gym_PT.Gym_PT.imageupload;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;

import java.io.IOException;
import java.time.Duration;
import java.util.UUID;

@Service
public class S3Uploader {

    private final S3Client s3Client;
    private final S3Presigner s3Presigner;

    @Value("${cloud.aws.s3.bucket}")
    private String bucketName;

    public S3Uploader(
            @Value("${cloud.aws.credentials.access-key}") String accessKey,
            @Value("${cloud.aws.credentials.secret-key}") String secretKey,
            @Value("${cloud.aws.region.static}") String region
    ) {
        AwsBasicCredentials credentials = AwsBasicCredentials.create(accessKey, secretKey);
        Region awsRegion = Region.of(region);

        this.s3Client = S3Client.builder()
                .region(awsRegion)
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build();

        this.s3Presigner = S3Presigner.builder()
                .region(awsRegion)
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build();
    }

    public String uploadFile(MultipartFile file) throws IOException {
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

        // ACL 없이 업로드 (비공개)
        PutObjectRequest request = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(fileName)
                .contentType(file.getContentType())
                .build();

        s3Client.putObject(request, RequestBody.fromInputStream(file.getInputStream(), file.getSize()));

        // Presigned URL 생성 (10분 유효)
        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket(bucketName)
                .key(fileName)
                .build();

        GetObjectPresignRequest presignRequest = GetObjectPresignRequest.builder()
                .signatureDuration(Duration.ofMinutes(10)) // 유효 시간
                .getObjectRequest(getObjectRequest)
                .build();

        return s3Presigner.presignGetObject(presignRequest).url().toString();
    }
}
