package com.gkcorex.catalyst.ai.security;

import java.util.List;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public record JwtUserPrincipal(
    Long userId, String email, List<SimpleGrantedAuthority> authorities) {}
