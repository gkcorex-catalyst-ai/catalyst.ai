package com.gkcorex.catalyst.ai.dtos.auth;

public record LoginRequest(
        String email,
        String password
) {
}
