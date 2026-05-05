package com.gkcorex.catalyst.ai.services;

import com.gkcorex.catalyst.ai.dtos.subscription.CheckoutRequest;
import com.gkcorex.catalyst.ai.dtos.subscription.CheckoutResponse;
import com.gkcorex.catalyst.ai.dtos.subscription.PortalResponse;
import com.stripe.model.StripeObject;
import java.util.Map;

public interface PaymentProcessorService {

  CheckoutResponse createCheckoutSessionUrl(CheckoutRequest checkoutRequest);

  PortalResponse openCustomerPortal();

  void handleWebhookEvent(String type, StripeObject stripeObject, Map<String, String> metaData);
}
