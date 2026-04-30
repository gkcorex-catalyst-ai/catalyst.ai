package com.gkcorex.catalyst.ai.dtos.member;

import com.gkcorex.catalyst.ai.enums.ProjectRole;
import jakarta.validation.constraints.NotNull;

public record UpdateMemberRoleRequest(@NotNull ProjectRole role) {}
