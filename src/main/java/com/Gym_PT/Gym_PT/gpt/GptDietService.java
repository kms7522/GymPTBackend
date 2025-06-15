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

    public String generateMeal(String goal, String style) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(gptConfig.getApiKey());

        Map<String, Object> message = Map.of(
                "role", "user",
                "content", String.format("식단 목표는 %s이며, %s 스타일의 하루 식단을 추천해줘. 아침, 점심, 저녁으로 나눠줘. 음식명과 간단한 설명, 칼로리도 알려줘.", goal, style)
        );

        Map<String, Object> requestBody = Map.of(
                "model", "gpt-3.5-turbo",
                "messages", List.of(message),
                "temperature", 0.8
        );

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity("https://api.openai.com/v1/chat/completions", entity, Map.class);
        List<Map<String, Object>> choices = (List<Map<String, Object>>) response.getBody().get("choices");

        return (String) ((Map<String, Object>) choices.get(0).get("message")).get("content");
    }
}
