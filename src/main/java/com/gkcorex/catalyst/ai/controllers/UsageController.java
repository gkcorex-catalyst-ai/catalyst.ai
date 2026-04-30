package com.gkcorex.catalyst.ai.controllers;

import com.gkcorex.catalyst.ai.dtos.subscription.PlanLimitsResponse;
import com.gkcorex.catalyst.ai.dtos.subscription.UsageTodayResponse;
import com.gkcorex.catalyst.ai.services.UsageService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usage")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UsageController {

  UsageService usageService;

  @GetMapping("/today")
  public ResponseEntity<UsageTodayResponse> getTodayUsage() {
    Long userId = 1L;
    return ResponseEntity.ok(usageService.getTodayUsageOfUser(userId));
  }

  @GetMapping("/limits")
  public ResponseEntity<PlanLimitsResponse> getPlanLimits() {
    Long userId = 1L;
    return ResponseEntity.ok(usageService.getCurrentSubscriptionLimitsOfUser(userId));
  }
}
