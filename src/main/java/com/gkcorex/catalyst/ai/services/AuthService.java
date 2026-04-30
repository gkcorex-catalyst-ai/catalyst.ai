package com.gkcorex.catalyst.ai.services;

import com.gkcorex.catalyst.ai.dtos.auth.AuthResponse;
import com.gkcorex.catalyst.ai.dtos.auth.LoginRequest;
import com.gkcorex.catalyst.ai.dtos.auth.SignUpRequest;

public interface AuthService {

  AuthResponse login(LoginRequest loginRequest);

  AuthResponse signup(SignUpRequest signUpRequest);
}
