package com.gkcorex.catalyst.ai.entities;

import com.gkcorex.catalyst.ai.enums.ProjectRole;
import java.time.Instant;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjectMember {

  ProjectMemberId id;

  Project project;

  User user;

  ProjectRole projectRole;

  Instant invitedAt;

  Instant acceptedAt;
}
