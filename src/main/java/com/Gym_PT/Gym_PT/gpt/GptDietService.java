package com.Gym_PT.Gym_PT.gpt;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class GptDietService {

    private final GptConfig gptConfig;

    public String generateDiet(int age, String gender, int height, int weight, String goal, String mealType) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(gptConfig.getApiKey());

        String prompt = String.format(
                "사용자의 정보는 다음과 같아.\n" +
                        "- 나이: %d세\n" +
                        "- 성별: %s\n" +
                        "- 키: %dcm\n" +
                        "- 몸무게: %dkg\n" +
                        "- 식단 목표: %s\n\n" +
                        "%s에 알맞은 식단을 추천해줘. 음식명, 설명, 칼로리뿐만 아니라 **정확한 섭취량(예: 150g, 1컵, 200ml 등)**도 함께 알려줘.",
                age, gender, height, weight, goal, mealType
        );

        Map<String, Object> message = Map.of(
                "role", "user",
                "content", prompt
        );

        Map<String, Object> requestBody = Map.of(
                "model", "gpt-3.5-turbo",
                "messages", List.of(message),
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
