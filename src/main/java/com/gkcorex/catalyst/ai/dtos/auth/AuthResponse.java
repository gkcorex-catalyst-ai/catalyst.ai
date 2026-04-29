package com.gkcorex.catalyst.ai.dtos.auth;

public record AuthResponse(
        String token,
        UserProfileResponse user
) {
}
