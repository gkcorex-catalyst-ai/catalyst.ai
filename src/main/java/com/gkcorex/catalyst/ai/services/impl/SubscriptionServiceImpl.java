package com.gkcorex.catalyst.ai.services.impl;

import com.gkcorex.catalyst.ai.dtos.subscription.CheckoutRequest;
import com.gkcorex.catalyst.ai.dtos.subscription.CheckoutResponse;
import com.gkcorex.catalyst.ai.dtos.subscription.PortalResponse;
import com.gkcorex.catalyst.ai.dtos.subscription.SubscriptionResponse;
import com.gkcorex.catalyst.ai.services.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {
  @Override
  public SubscriptionResponse getCurrentSubscription(Long userId) {
    return null;
  }

  @Override
  public CheckoutResponse createCheckoutSessionUrl(Long userId, CheckoutRequest checkoutRequest) {
    return null;
  }

  @Override
  public PortalResponse openCustomerPortal(Long userId) {
    return null;
  }
}
