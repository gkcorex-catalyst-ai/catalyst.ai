package com.gkcorex.catalyst.ai.entities;

import com.gkcorex.catalyst.ai.enums.MessageRole;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChatMessage {

    @Id
    Long id;

    Project project;

    ChatSession chatSession;

    String content;

    /*
        JSON Array of Tools Called
     */
    String toolCalls;

    Integer tokensUsed;

    MessageRole role;

    Instant createdAt;
}
