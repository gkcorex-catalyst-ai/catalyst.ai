package com.gkcorex.catalyst.ai.controllers;

import com.gkcorex.catalyst.ai.dtos.subscription.*;
import com.gkcorex.catalyst.ai.services.PaymentProcessorService;
import com.gkcorex.catalyst.ai.services.PlanService;
import com.gkcorex.catalyst.ai.services.SubscriptionService;
import com.stripe.exception.SignatureVerificationException;
import com.stripe.model.Event;
import com.stripe.model.EventDataObjectDeserializer;
import com.stripe.model.StripeObject;
import com.stripe.model.checkout.Session;
import com.stripe.net.Webhook;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BillingController {

  @Value("${stripe.webhook.secret}")
  String webhookSecret;

  final PlanService planService;

  final SubscriptionService subscriptionService;

  final PaymentProcessorService paymentProcessorService;

  @GetMapping("/api/plans")
  public ResponseEntity<List<PlanResponse>> getAllPlans() {
    return ResponseEntity.ok(planService.getActivePlans());
  }

  @GetMapping("/api/me/subscription")
  public ResponseEntity<SubscriptionResponse> getMySubscription() {
    return ResponseEntity.ok(subscriptionService.getCurrentSubscription());
  }

  @PostMapping("/api/payments/checkout")
  public ResponseEntity<CheckoutResponse> createCheckoutResponse(
      @RequestBody CheckoutRequest checkoutRequest) {
    return ResponseEntity.ok(paymentProcessorService.createCheckoutSessionUrl(checkoutRequest));
  }

  @PostMapping("/api/payments/portal")
  public ResponseEntity<PortalResponse> openCustomerPortal() {
    return ResponseEntity.ok(paymentProcessorService.openCustomerPortal());
  }

  @PostMapping("/webhooks/payment")
  public ResponseEntity<String> handlePaymentWebhook(
      @RequestBody String payload, @RequestHeader("Stripe-Signature") String signature) {
    try {
      Event event = Webhook.constructEvent(payload, signature, webhookSecret);
      EventDataObjectDeserializer deserializer = event.getDataObjectDeserializer();
      StripeObject stripeObject = null;

      if (deserializer.getObject().isPresent()) stripeObject = deserializer.getObject().get();
      else {
        try {
          stripeObject = deserializer.deserializeUnsafe();
          if (stripeObject == null) {
            return ResponseEntity.ok().build();
          }
        } catch (Exception e) {
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("Deserialization failed");
        }
      }
      Map<String, String> metaData = new HashMap<>();
      if (stripeObject instanceof Session session) metaData = session.getMetadata();

      paymentProcessorService.handleWebhookEvent(event.getType(), stripeObject, metaData);
      return ResponseEntity.ok().build();
    } catch (SignatureVerificationException ex) {
      throw new RuntimeException(ex);
    }
  }
}
