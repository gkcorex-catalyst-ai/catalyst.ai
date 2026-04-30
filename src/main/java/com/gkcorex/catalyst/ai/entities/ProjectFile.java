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
public class ProjectFile {

  @Id Long id;

  Project project;

  String path;

  String minioObjectKey;

  Instant createdAt;

  Instant updatedAt;

  User createdBy;

  User updatedBy;
}
