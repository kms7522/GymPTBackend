package com.Gym_PT.Gym_PT.gpt;

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

    public String generateRoutine(int age, String gender, int height, int weight, String goal, String bodyPart, String level) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(gptConfig.getApiKey());

        Map<String, Object> systemMessage = Map.of(
                "role", "system",
                "content", "당신은 전문 퍼스널 트레이너입니다. 사용자의 신체 정보와 목표에 맞는 하루 운동 루틴을 제공합니다."
        );

        String userPrompt = String.format(
                """
                아래 조건을 바탕으로 하루 운동 루틴을 구성해줘.
                - 나이: %d세
                - 성별: %s
                - 키: %dcm
                - 몸무게: %dkg
                - 운동 목표: %s
                - 운동 부위: %s
                - 운동 수준: %s

                부위별 운동 목록, 세트 수, 반복 횟수, 휴식 시간까지 포함해서 알려줘.
                """,
                age, gender, height, weight, goal, bodyPart, level
        );

        Map<String, Object> userMessage = Map.of(
                "role", "user",
                "content", userPrompt
        );

        Map<String, Object> requestBody = Map.of(
                "model", "gpt-3.5-turbo",
                "messages", List.of(systemMessage, userMessage),
                "temperature", 0.8
        );

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity("https://api.openai.com/v1/chat/completions", entity, Map.class);
        List<Map<String, Object>> choices = (List<Map<String, Object>>) response.getBody().get("choices");

        return (String) ((Map<String, Object>) choices.get(0).get("message")).get("content");
    }
}
