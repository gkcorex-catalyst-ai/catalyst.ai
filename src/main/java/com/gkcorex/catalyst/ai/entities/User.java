package com.gkcorex.catalyst.ai.entities;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.Collection;
import java.util.List;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  String username;

  String password;

  String name;

  @Column(unique = true)
  String stripeCustomerId;

  @CreationTimestamp Instant createdAt;

  @UpdateTimestamp Instant updatedAt;

  Instant deletedAt;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of();
  }
}
