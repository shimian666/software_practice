package org.yeyushengfaning.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

public class DeepseekConfig {
    @Value("${deepseek.apiKey}")
    private String apiKey;
    @Value("${deepseek.base-url}")
    private String baseUrl;
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
