package com.dk.randomanimal.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public org.springframework.web.client.RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
