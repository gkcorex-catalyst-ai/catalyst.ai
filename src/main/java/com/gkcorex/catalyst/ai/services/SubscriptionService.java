package com.gkcorex.catalyst.ai.services;

import com.gkcorex.catalyst.ai.dtos.subscription.CheckoutRequest;
import com.gkcorex.catalyst.ai.dtos.subscription.CheckoutResponse;
import com.gkcorex.catalyst.ai.dtos.subscription.PortalResponse;
import com.gkcorex.catalyst.ai.dtos.subscription.SubscriptionResponse;

public interface SubscriptionService {

  SubscriptionResponse getCurrentSubscription(Long userId);

  CheckoutResponse createCheckoutSessionUrl(Long userId, CheckoutRequest checkoutRequest);

  PortalResponse openCustomerPortal(Long userId);
}
