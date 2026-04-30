package com.gkcorex.catalyst.ai.services.impl;

import com.gkcorex.catalyst.ai.dtos.auth.UserProfileResponse;
import com.gkcorex.catalyst.ai.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  @Override
  public UserProfileResponse getProfile(Long userId) {
    return null;
  }
}
