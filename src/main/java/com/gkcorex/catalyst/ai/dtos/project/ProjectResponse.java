package com.gkcorex.catalyst.ai.dtos.project;

import com.gkcorex.catalyst.ai.dtos.auth.UserProfileResponse;
import java.time.Instant;

public record ProjectResponse(
    Long id, String name, Instant createdAt, Instant updatedAt, UserProfileResponse owner) {}
