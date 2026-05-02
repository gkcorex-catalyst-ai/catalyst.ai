package com.gkcorex.catalyst.ai.services.impl;

import com.gkcorex.catalyst.ai.dtos.auth.AuthResponse;
import com.gkcorex.catalyst.ai.dtos.auth.LoginRequest;
import com.gkcorex.catalyst.ai.dtos.auth.SignUpRequest;
import com.gkcorex.catalyst.ai.entities.User;
import com.gkcorex.catalyst.ai.exceptions.BadRequestException;
import com.gkcorex.catalyst.ai.mappers.UserMapper;
import com.gkcorex.catalyst.ai.repositories.UserRepository;
import com.gkcorex.catalyst.ai.security.JwtAuthUtil;
import com.gkcorex.catalyst.ai.services.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthServiceImpl implements AuthService {

  UserRepository userRepository;

  UserMapper userMapper;

  PasswordEncoder passwordEncoder;

  JwtAuthUtil jwtAuthUtil;

  AuthenticationManager authenticationManager;

  @Override
  public AuthResponse signup(SignUpRequest signUpRequest) {
    userRepository
        .findByUsername(signUpRequest.username())
        .ifPresent(
            user -> {
              throw new BadRequestException("Username Already Exists, Please Sign in!");
            });
    User user = userMapper.mapSignUpRequestToEntity(signUpRequest);
    user.setPassword(passwordEncoder.encode(signUpRequest.password()));
    user = userRepository.save(user);
    String accessToken = jwtAuthUtil.generateAccessToken(user);
    return new AuthResponse(accessToken, userMapper.mapEntityToUserProfileResponse(user));
  }

  @Override
  public AuthResponse login(LoginRequest loginRequest) {
    Authentication authentication =
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginRequest.username(), loginRequest.password()));
    User user = (User) authentication.getPrincipal();
    String accessToken = jwtAuthUtil.generateAccessToken(user);
    return new AuthResponse(accessToken, userMapper.mapEntityToUserProfileResponse(user));
  }
}
