package com.gkcorex.catalyst.ai.dtos.project;

import java.time.Instant;

public record ProjectResponse(Long id, String name, Instant createdAt, Instant updatedAt) {}
