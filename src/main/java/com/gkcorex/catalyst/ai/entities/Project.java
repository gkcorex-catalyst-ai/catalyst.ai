package com.gkcorex.catalyst.ai.entities;

import jakarta.persistence.*;
import java.time.Instant;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
    name = "projects",
    indexes = {
      @Index(name = "idx_projects_updated_at_desc", columnList = "updated_at DESC, deleted_at"),
      @Index(name = "idx_project_deleted_at", columnList = "deleted_at")
    })
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Project {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(nullable = false)
  String name;

  //
  //  @ManyToOne
  //  @JoinColumn(name = "owner_id", nullable = false)
  //  User owner;

  Boolean isPublic = false;

  @CreationTimestamp Instant createdAt;

  @UpdateTimestamp Instant updatedAt;

  /*
   Soft Delete Only
  */
  Instant deletedAt;
}
