package com.gkcorex.catalyst.ai.dtos.subscription;

public record PlanResponse(
    Long id,
    String name,
    Integer maxProjects,
    Integer maxTokenPerDay,
    Integer maxPreview,
    Boolean unlimitedAi,
    String price) {}
