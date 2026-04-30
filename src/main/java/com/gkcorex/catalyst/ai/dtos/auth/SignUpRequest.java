package com.gkcorex.catalyst.ai.dtos.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SignUpRequest(
    @Email @NotBlank String username,
    @Size(min = 3, max = 100) String name,
    @Size(min = 8, max = 16) String password) {}
