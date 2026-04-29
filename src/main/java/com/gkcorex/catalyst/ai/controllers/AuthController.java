package com.gkcorex.catalyst.ai.controllers;

import com.gkcorex.catalyst.ai.dtos.auth.AuthResponse;
import com.gkcorex.catalyst.ai.dtos.auth.LoginRequest;
import com.gkcorex.catalyst.ai.dtos.auth.SignUpRequest;
import com.gkcorex.catalyst.ai.dtos.auth.UserProfileResponse;
import com.gkcorex.catalyst.ai.services.AuthService;
import com.gkcorex.catalyst.ai.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(SignUpRequest signUpRequest){
        return ResponseEntity.ok(authService.signup(signUpRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(LoginRequest loginRequest){
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getProfile(){
        Long userId = 1L;
        return ResponseEntity.ok(userService.getProfile(userId));
    }
}
