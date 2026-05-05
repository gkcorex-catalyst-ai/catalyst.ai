package com.gkcorex.catalyst.ai.entities;

import com.gkcorex.catalyst.ai.enums.SubscriptionStatus;
import jakarta.persistence.Id;
import java.time.Instant;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Subscription {

  @Id Long id;

  User user;

  Plan plan;

  String subscriptionId;

  SubscriptionStatus status;

  Instant currentPeriodStart;

  Instant currentPeriodEnd;

  Boolean cancelAtPeriodEnd = false;

  Instant createdAt;

  Instant updateAt;
}
