package com.gkcorex.catalyst.ai.enums;

import static com.gkcorex.catalyst.ai.enums.ProjectPermission.*;

import java.util.Set;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ProjectRole {
  EDITOR(VIEW, EDIT, VIEW_MEMBERS),
  VIEWER(VIEW, VIEW_MEMBERS),
  OWNER(VIEW, EDIT, DELETE, VIEW_MEMBERS, MANAGE_MEMBERS);

  ProjectRole(ProjectPermission... permissions) {
    this.permissions = Set.of(permissions);
  }

  private final Set<ProjectPermission> permissions;
}
