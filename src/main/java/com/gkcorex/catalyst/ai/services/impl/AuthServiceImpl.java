package com.gkcorex.catalyst.ai.services.impl;

import com.gkcorex.catalyst.ai.dtos.auth.AuthResponse;
import com.gkcorex.catalyst.ai.dtos.auth.LoginRequest;
import com.gkcorex.catalyst.ai.dtos.auth.SignUpRequest;
import com.gkcorex.catalyst.ai.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

  @Override
  public AuthResponse login(LoginRequest loginRequest) {
    return null;
  }

  @Override
  public AuthResponse signup(SignUpRequest signUpRequest) {
    return null;
  }
}
