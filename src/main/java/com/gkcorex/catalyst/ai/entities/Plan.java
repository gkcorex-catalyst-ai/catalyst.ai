package com.gkcorex.catalyst.ai.entities;

import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Plan {

  @Id Long id;

  String name;

  String stripePriceId;

  Integer maxProjects;

  Integer maxTokenPerDay;

  Integer maxPreviews;

  /*
     Unlimited access to LLM, Ignore maxTokenPerDay if true
  */
  Boolean unlimitedAi;

  Boolean active;
}
