package org.yeyushengfaning.service.imp;

import org.springframework.stereotype.Service;
import org.yeyushengfaning.service.AiService;

@Service
public class AiServiceImpl implements AiService {
    @Override
    public String chat(String message) {
        return "AI智能体的回答: " + message;
    }
}
