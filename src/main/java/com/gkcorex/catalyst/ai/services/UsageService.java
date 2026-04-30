package com.gkcorex.catalyst.ai.services;

import com.gkcorex.catalyst.ai.dtos.subscription.PlanLimitsResponse;
import com.gkcorex.catalyst.ai.dtos.subscription.UsageTodayResponse;

public interface UsageService {

  UsageTodayResponse getTodayUsageOfUser(Long userId);

  PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId);
}
