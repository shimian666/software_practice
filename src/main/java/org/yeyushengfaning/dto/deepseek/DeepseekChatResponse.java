package org.yeyushengfaning.dto.deepseek;

import java.util.List;

public record DeepseekChatResponse(List<Choice> choices) {

    public record Choice(Message message) {
    }

    public record Message(String role, String content) {
    }
}