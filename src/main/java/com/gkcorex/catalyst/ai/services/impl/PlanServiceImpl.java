package com.gkcorex.catalyst.ai.services.impl;

import com.gkcorex.catalyst.ai.dtos.subscription.PlanResponse;
import com.gkcorex.catalyst.ai.services.PlanService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService {
  @Override
  public List<PlanResponse> getActivePlans() {
    return List.of();
  }
}
