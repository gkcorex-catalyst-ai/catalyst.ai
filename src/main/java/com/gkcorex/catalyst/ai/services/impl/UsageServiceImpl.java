package com.gkcorex.catalyst.ai.services.impl;

import com.gkcorex.catalyst.ai.dtos.subscription.PlanLimitsResponse;
import com.gkcorex.catalyst.ai.dtos.subscription.UsageTodayResponse;
import com.gkcorex.catalyst.ai.services.UsageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsageServiceImpl implements UsageService {
  @Override
  public UsageTodayResponse getTodayUsageOfUser(Long userId) {
    return null;
  }

  @Override
  public PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId) {
    return null;
  }
}
