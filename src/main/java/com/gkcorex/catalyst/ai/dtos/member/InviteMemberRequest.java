package com.gkcorex.catalyst.ai.dtos.member;

import com.gkcorex.catalyst.ai.enums.ProjectRole;

public record InviteMemberRequest(String email, ProjectRole role) {}
