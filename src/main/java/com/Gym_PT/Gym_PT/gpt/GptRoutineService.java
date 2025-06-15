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

    public String generateRoutine(String goal, String bodyPart, String level) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(gptConfig.getApiKey());

        // GPT 프롬프트 구성
        Map<String, Object> message = Map.of(
                "role", "user",
                "content", String.format(
                        "운동 목표는 %s이고, 운동 부위는 %s이며, 난이도는 %s인 사람에게 맞는 하루 운동 루틴을 알려줘. 각 운동에 대해 세트 수, 반복 횟수, 적절한 무게 범위, 운동 순서, 유튜브 링크 예시도 함께 제공해줘.",
                        goal, bodyPart, level)
        );

        Map<String, Object> requestBody = Map.of(
                "model", "gpt-3.5-turbo",
                "messages", List.of(message),
                "temperature", 0.8
        );

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(
                "https://api.openai.com/v1/chat/completions", entity, Map.class
        );

        List<Map<String, Object>> choices = (List<Map<String, Object>>) response.getBody().get("choices");
        return (String) ((Map<String, Object>) choices.get(0).get("message")).get("content");
    }
}
