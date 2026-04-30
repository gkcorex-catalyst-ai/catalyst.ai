package com.gkcorex.catalyst.ai.dtos.subscription;

public record UsageTodayResponse(
    Integer tokensUsed, Integer tokensLimit, Integer previewsRunning, Integer previewsLimit) {}
