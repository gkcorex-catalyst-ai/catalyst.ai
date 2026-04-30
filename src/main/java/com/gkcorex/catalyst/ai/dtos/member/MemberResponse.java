package com.gkcorex.catalyst.ai.dtos.member;

import com.gkcorex.catalyst.ai.enums.ProjectRole;
import java.time.Instant;

public record MemberResponse(
    Long id, String name, String email, String avatarUrl, ProjectRole role, Instant invitedAt) {}
