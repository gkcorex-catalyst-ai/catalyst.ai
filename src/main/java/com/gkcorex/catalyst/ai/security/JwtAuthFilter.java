package com.gkcorex.catalyst.ai.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtAuthFilter extends OncePerRequestFilter {

  private final JwtAuthUtil jwtAuthUtil;
  private final HandlerExceptionResolver handlerExceptionResolver;

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    try {
      log.info("incoming request: {}", request.getRequestURI());

      final String tokenHeader = request.getHeader("Authorization");

      if (Objects.isNull(tokenHeader) || !tokenHeader.startsWith("Bearer ")) {
        filterChain.doFilter(request, response);
        return;
      }

      String token = tokenHeader.substring(7);
      JwtUserPrincipal user = jwtAuthUtil.verifyAccessToken(token);
      if (Objects.nonNull(user)
          && Objects.isNull(SecurityContextHolder.getContext().getAuthentication())) {
        UsernamePasswordAuthenticationToken authenticationToken =
            new UsernamePasswordAuthenticationToken(user, null, user.authorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
      }
      filterChain.doFilter(request, response);
    } catch (Exception e) {
      handlerExceptionResolver.resolveException(request, response, null, e);
    }
  }
}
