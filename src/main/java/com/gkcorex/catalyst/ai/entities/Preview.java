package com.gkcorex.catalyst.ai.entities;

import com.gkcorex.catalyst.ai.enums.PreviewStatus;
import jakarta.persistence.Id;
import java.time.Instant;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Preview {

  @Id Long id;

  Project project;

  String namespace;

  String podName;

  String previewUrl;

  PreviewStatus status;

  Instant createdAt;

  Instant startedAt;

  Instant terminatedAt;
}
