package com.gkcorex.catalyst.ai.entities;

import jakarta.persistence.Id;
import java.time.Instant;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UsageLog {

  @Id Long id;

  User user;

  Project project;

  String action;

  Integer tokensUsed;

  Integer durationMs;

  String metaData;

  Instant createdAt;
}
