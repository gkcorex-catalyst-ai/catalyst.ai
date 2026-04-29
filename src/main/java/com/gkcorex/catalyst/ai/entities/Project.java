package com.gkcorex.catalyst.ai.entities;

import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Project {

    @Id
    Long id;

    String name;

    User owner;

    Boolean isPublic;

    Instant createdAt;

    Instant updatedAt;

    Instant deletedAt;
}
