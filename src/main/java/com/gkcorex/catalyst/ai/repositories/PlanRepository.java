package com.gkcorex.catalyst.ai.repositories;

import com.gkcorex.catalyst.ai.entities.Plan;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Long> {
  Optional<Plan> findByStripePriceId(String id);
}
