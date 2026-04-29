package com.gkcorex.catalyst.ai.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    Long id;

    @Column(nullable = false)
    String email;

    String passwordHash;

    String name;

    String avatarUrl;

    Instant createdAt;

    Instant updatedAt;

    Instant deletedAt;
}
