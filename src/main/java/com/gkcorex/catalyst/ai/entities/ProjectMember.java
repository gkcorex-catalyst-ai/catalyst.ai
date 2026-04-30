package com.gkcorex.catalyst.ai.entities;

import com.gkcorex.catalyst.ai.enums.ProjectRole;
import jakarta.persistence.*;
import java.time.Instant;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "project_members")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjectMember {

  @EmbeddedId ProjectMemberId id;

  @ManyToOne
  @MapsId("projectId")
  Project project;

  @ManyToOne
  @MapsId("userId")
  User user;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  ProjectRole projectRole;

  Instant invitedAt;

  Instant acceptedAt;
}
