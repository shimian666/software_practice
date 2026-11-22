package org.yeyushengfaning.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

@Configuration
public class DeepseekConfig {
    @Value("${deepseek.api-key}")
    private String apiKey;
    @Value("${deepseek.base-url}")
    private String baseUrl;
    @Bean
    public RestClient deepseekRestClient() {
        return RestClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader(
                        HttpHeaders.AUTHORIZATION,
                        "Bearer " + apiKey
                )
                .defaultHeader(
                        HttpHeaders.CONTENT_TYPE,
                        MediaType.APPLICATION_JSON_VALUE
                )
                .build();
    }
}
