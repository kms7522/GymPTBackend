package com.Gym_PT.Gym_PT.imageupload;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/images")
public class ImageUploadController {

    private final S3Uploader s3Uploader;

    public ImageUploadController(S3Uploader s3Uploader) {
        this.s3Uploader = s3Uploader;
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            String presignedUrl = s3Uploader.uploadFile(file);
            return ResponseEntity.ok(presignedUrl); // 10분 유효 URL
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("업로드 실패: " + e.getMessage());
        }
    }
}
