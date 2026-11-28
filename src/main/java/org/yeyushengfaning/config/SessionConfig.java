package org.yeyushengfaning.config;

import org.springframework.ai.session.DefaultSessionService;
import org.springframework.ai.session.InMemorySessionRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SessionConfig {

    @Bean
    public DefaultSessionService sessionService() {
        return DefaultSessionService.builder().sessionRepository(InMemorySessionRepository.builder().build()).build();
    }
}
