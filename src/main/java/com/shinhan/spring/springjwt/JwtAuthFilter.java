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
                // JWT���� userId ����
                String mid = jwtUtil.getUserId(token);

                // DB �Ǵ� �޸𸮿��� ����� ���� ��ȸ
               MemberEntity member = memberService.findByMidOnly(mid);  // findByUserId�� ����� ����

                if (member != null) {
                    // ��Ʈ�ѷ����� ����� �� �ֵ��� request�� ����� ���� ����
                    request.setAttribute("loginMember", member);
                }
            }
        }

        filterChain.doFilter(request, response);
    }
}