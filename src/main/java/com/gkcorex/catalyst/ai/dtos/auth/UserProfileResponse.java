package com.gkcorex.catalyst.ai.dtos.auth;

public record UserProfileResponse(
        Long id,
        String email,
        String name,
        String avatarUrl
) {
}
