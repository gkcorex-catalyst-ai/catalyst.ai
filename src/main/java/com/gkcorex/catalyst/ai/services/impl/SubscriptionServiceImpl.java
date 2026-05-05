package com.gkcorex.catalyst.ai.services.impl;

import com.gkcorex.catalyst.ai.dtos.subscription.SubscriptionResponse;
import com.gkcorex.catalyst.ai.enums.SubscriptionStatus;
import com.gkcorex.catalyst.ai.services.SubscriptionService;
import java.time.Instant;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SubscriptionServiceImpl implements SubscriptionService {

  @Override
  public SubscriptionResponse getCurrentSubscription() {
    return null;
  }

  @Override
  public void activateSubscription(
      Long userId, Long planId, String subscriptionId, String customerId) {}

  @Override
  public void updateSubscription(
      String id,
      SubscriptionStatus status,
      Instant periodStart,
      Instant periodEnd,
      Long planId,
      Boolean cancelAtPeriodEnd) {}
}
