package com.Gym_PT.Gym_PT.gpt;

import com.Gym_PT.Gym_PT.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class GptRoutineService {

    private final GptConfig gptConfig;

    public String generateRoutine(User user) {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(gptConfig.getApiKey());

        // 역할 부여
        Map<String, Object> systemMessage = Map.of(
                "role", "system",
                "content", "당신은 전문 퍼스널 트레이너입니다. 사용자의 상태에 맞춰 하루 운동 루틴을 구성하세요. 출력 형식은 요청에 따라 엄격히 따르세요."
        );

        // 사용자 프롬프트 구성
        String userPrompt = String.format(
                """
                당신은 전문 피트니스 코치입니다. 아래 정보를 기반으로 하루 운동 루틴을 JSON 형식으로 구성해주세요.

                성별: %s
                나이: %d
                키/몸무게: %.1fcm / %.1fkg
                운동 숙련도: %s
                운동 목적: %s
                운동 시간: 하루 %d분
                운동 장소: %s
                분할 전략: %s
                요청 형식:
                [running_workout]: 운동명, 속도(km/h), 시간(분)
                [non_weight_workout]: 운동명, 횟수, 세트수
                [weight_workout]: 운동명, 무게(kg), 횟수, 세트수

                제약 조건:
                같은 부위는 주 2회 자극
                같은 운동은 반복하지 말고 변형 동작으로 구성

                결과는 JSON 형식으로 구성해 주세요.
                """,
                user.getGender(),
                user.getAge(),
                user.getHeight(),
                user.getWeight(),
                user.getExperienceLevel(),
                user.getGoal(),
                user.getDuration(),
                user.getLocation(),
                user.getSplitStrategy()
        );

        Map<String, Object> userMessage = Map.of(
                "role", "user",
                "content", userPrompt
        );

        Map<String, Object> requestBody = Map.of(
                "model", "gpt-4o",
                "messages", List.of(systemMessage, userMessage),
                "temperature", 0.8
        );

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(
                "https://api.openai.com/v1/chat/completions",
                entity,
                Map.class
        );

        List<Map<String, Object>> choices = (List<Map<String, Object>>) response.getBody().get("choices");
        return (String) ((Map<String, Object>) choices.get(0).get("message")).get("content");
    }
}
