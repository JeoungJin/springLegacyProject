package com.shinhan.spring.springjwt;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import lombok.RequiredArgsConstructor;

//Spring Security 없이 사용할 경우 (Interceptor 기반)
@Component
@RequiredArgsConstructor
public class JwtAuthenticationInterceptor implements HandlerInterceptor {

    private final JwtUtil jwtUtil;
    private final MemberService memberService;
 

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            if (jwtUtil.validateToken(token)) {
                String mid = jwtUtil.getUserId(token);
                MemberEntity member = memberService.findByMidOnly(mid);
                // 로그인 사용자 정보를 request에 저장
                request.setAttribute("loginMember", member);
            }
        }

        return true; // 계속 진행
    }
}