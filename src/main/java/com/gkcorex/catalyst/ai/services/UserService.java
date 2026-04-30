package com.gkcorex.catalyst.ai.services;

import com.gkcorex.catalyst.ai.dtos.auth.UserProfileResponse;

public interface UserService {

  UserProfileResponse getProfile(Long userId);
}
