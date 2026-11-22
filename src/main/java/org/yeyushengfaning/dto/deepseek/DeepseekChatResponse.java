package org.yeyushengfaning.dto.deepseek;

import java.util.List;

public record DeepseekChatResponse(List<choice> choices) {
    public record Message(String role, String content) {
    }

    public record choice(String role, String content) {
    }
}