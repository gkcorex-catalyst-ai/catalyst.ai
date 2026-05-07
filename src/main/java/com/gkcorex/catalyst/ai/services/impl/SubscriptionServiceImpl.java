package com.gkcorex.catalyst.ai.services.impl;

import com.gkcorex.catalyst.ai.dtos.subscription.SubscriptionResponse;
import com.gkcorex.catalyst.ai.entities.Subscription;
import com.gkcorex.catalyst.ai.enums.SubscriptionStatus;
import com.gkcorex.catalyst.ai.mappers.SubscriptionMapper;
import com.gkcorex.catalyst.ai.repositories.SubscriptionRepository;
import com.gkcorex.catalyst.ai.security.JwtAuthUtil;
import com.gkcorex.catalyst.ai.services.SubscriptionService;
import java.time.Instant;
import java.util.Set;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SubscriptionServiceImpl implements SubscriptionService {

    JwtAuthUtil jwtAuthUtil;

    SubscriptionRepository subscriptionRepository;

    SubscriptionMapper subscriptionMapper;

  @Override
  public SubscriptionResponse getCurrentSubscription() {
        Long userId = jwtAuthUtil.getCurrentUserId();
        var currentSubscription = subscriptionRepository.findByUserIdAndStatusIn(userId, Set.of(
                SubscriptionStatus.ACTIVE,
                SubscriptionStatus.PAST_DUE,
                SubscriptionStatus.TRAILING
        )).orElse(
                new Subscription()
        );
        return subscriptionMapper.mapSubscriptionToSubscriptionResponse(currentSubscription);
  }

  @Override
  public void activateSubscription(
      Long userId, Long planId, String subscriptionId, String customerId) {

  }

  @Override
  public void updateSubscription(
      String subscriptionId,
      SubscriptionStatus status,
      Instant periodStart,
      Instant periodEnd,
      Long planId,
      Boolean cancelAtPeriodEnd) {}

    @Override
    public void cancelSubscription(String subscriptionId) {

    }

    @Override
    public void renewSubscriptionPeriod(String subId, Instant periodStart, Instant periodEnd) {

    }

    @Override
    public void markSubscriptionPastDue(String subId) {

    }
}
