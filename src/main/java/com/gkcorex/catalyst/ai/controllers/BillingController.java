package com.gkcorex.catalyst.ai.controllers;

import com.gkcorex.catalyst.ai.dtos.subscription.*;
import com.gkcorex.catalyst.ai.services.PlanService;
import com.gkcorex.catalyst.ai.services.SubscriptionService;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class BillingController {

  PlanService planService;

  SubscriptionService subscriptionService;

  @GetMapping("/api/plans")
  public ResponseEntity<List<PlanResponse>> getAllPlans() {
    return ResponseEntity.ok(planService.getActivePlans());
  }

  @GetMapping("/api/me/subscription")
  public ResponseEntity<SubscriptionResponse> getMySubscription() {
    Long userId = 1L;
    return ResponseEntity.ok(subscriptionService.getCurrentSubscription(userId));
  }

  @PostMapping("/api/stripe/checkout")
  public ResponseEntity<CheckoutResponse> createCheckoutResponse(
      @RequestBody CheckoutRequest checkoutRequest) {
    Long userId = 1L;
    return ResponseEntity.ok(subscriptionService.createCheckoutSessionUrl(userId, checkoutRequest));
  }

  @PostMapping("/api/stripe/portal")
  public ResponseEntity<PortalResponse> openCustomerPortal() {
    Long userId = 1L;
    return ResponseEntity.ok(subscriptionService.openCustomerPortal(userId));
  }
}
