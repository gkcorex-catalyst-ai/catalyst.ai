package com.gkcorex.catalyst.ai.entities;

import com.gkcorex.catalyst.ai.enums.PreviewStatus;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Preview {

    @Id
    Long id;

    Project project;

    String namespace;

    String podName;

    String previewUrl;

    PreviewStatus status;

    Instant createdAt;

    Instant startedAt;

    Instant terminatedAt;
}
