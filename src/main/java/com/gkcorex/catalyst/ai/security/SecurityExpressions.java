package com.gkcorex.catalyst.ai.security;

import static com.gkcorex.catalyst.ai.enums.ProjectPermission.*;

import com.gkcorex.catalyst.ai.enums.ProjectPermission;
import com.gkcorex.catalyst.ai.repositories.ProjectMemberRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component("security")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SecurityExpressions {

  ProjectMemberRepository projectMemberRepository;

  JwtAuthUtil jwtAuthUtil;

  public boolean canViewProject(Long projectId) {
    return hasPermission(projectId, VIEW);
  }

  public boolean canEditProject(Long projectId) {
    return hasPermission(projectId, EDIT);
  }

  public boolean canDeleteProject(Long projectId) {
    return hasPermission(projectId, DELETE);
  }

  public boolean canViewMembers(Long projectId) {
    return hasPermission(projectId, VIEW_MEMBERS);
  }

  public boolean canManageMembers(Long projectId) {
    return hasPermission(projectId, MANAGE_MEMBERS);
  }

  private boolean hasPermission(Long projectId, ProjectPermission projectPermission) {
    Long userId = jwtAuthUtil.getCurrentUserId();
    return projectMemberRepository
        .findRoleByProjectIdAndUserId(projectId, userId)
        .map(role -> role.getPermissions().contains(projectPermission))
        .orElse(false);
  }
}
