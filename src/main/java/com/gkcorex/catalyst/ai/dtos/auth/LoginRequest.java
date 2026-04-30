package com.gkcorex.catalyst.ai.dtos.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequest(
    @Email @NotBlank String username, @Size(min = 8, max = 16) String password) {}
