package com.Gym_PT.Gym_PT.gpt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GptConfig {

    @Value("${gpt.api.key}")
    private String apiKey;

    public String getApiKey() {
        return apiKey;
    }
}
