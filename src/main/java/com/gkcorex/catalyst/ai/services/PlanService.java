package com.gkcorex.catalyst.ai.services;

import com.gkcorex.catalyst.ai.dtos.subscription.PlanResponse;
import java.util.List;

public interface PlanService {

  List<PlanResponse> getActivePlans();
}
