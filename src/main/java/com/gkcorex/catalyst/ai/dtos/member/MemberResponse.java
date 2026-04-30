package com.gkcorex.catalyst.ai.dtos.member;

import com.gkcorex.catalyst.ai.enums.ProjectRole;
import java.time.Instant;

public record MemberResponse(
    Long userId,
    String name,
    String email,
    String avatarUrl,
    ProjectRole projectRole,
    Instant invitedAt) {}
