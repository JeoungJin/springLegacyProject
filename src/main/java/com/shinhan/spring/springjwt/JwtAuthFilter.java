package com.shinhan.spring.springjwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {
    private final MemberService memberService;
    private final JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);

            if (jwtUtil.validateToken(token)) {
                // JWT에서 userId 추출
                String mid = jwtUtil.getUserId(token);

                // DB 또는 메모리에서 사용자 정보 조회
               MemberEntity member = memberService.findByMidOnly(mid);  // findByUserId는 사용자 정의

                if (member != null) {
                    // 컨트롤러에서 사용할 수 있도록 request에 사용자 정보 주입
                    request.setAttribute("loginMember", member);
                }
            }
        }

        filterChain.doFilter(request, response);
    }
}