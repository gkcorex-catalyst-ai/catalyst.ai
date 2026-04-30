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
@Table(name = "projects")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Project {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(nullable = false)
  String name;

  @ManyToOne
  @JoinColumn(name = "owner_id", nullable = false)
  User owner;

  Boolean isPublic;

  @CreationTimestamp Instant createdAt;

  @UpdateTimestamp Instant updatedAt;

  Instant deletedAt;
}
