package com.gkcorex.catalyst.ai.dtos.project;

import jakarta.validation.constraints.NotBlank;

public record ProjectRequest(@NotBlank String name) {}
