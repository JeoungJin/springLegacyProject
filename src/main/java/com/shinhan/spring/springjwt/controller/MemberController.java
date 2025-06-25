package com.shinhan.spring.springjwt.controller;

import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shinhan.spring.springjwt.AccessRefreshTokenDTO;
import com.shinhan.spring.springjwt.JwtUtil;
import com.shinhan.spring.springjwt.LoginRequestDto;
import com.shinhan.spring.springjwt.MemberEntity;
import com.shinhan.spring.springjwt.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

	 private final MemberService memberService;
	    private final JwtUtil jwtUtil;

	    /**
	     * 1. 회원가입 (insert + access/refresh token 발급)
	     */
	    @PostMapping("/register")
	    public ResponseEntity<?> register(@RequestBody MemberEntity member) {
	        AccessRefreshTokenDTO tokens = memberService.insert(member);

	        // refreshToken을 HttpOnly 쿠키로 설정
	        ResponseCookie cookie = ResponseCookie.from("refreshToken", tokens.getRefreshToken())
	                .httpOnly(true)
	                .secure(true)
	                .path("/api/token")
	                .maxAge(7 * 24 * 60 * 60) // 7일
	                .sameSite("Strict")
	                .build();

	        return ResponseEntity.ok()
	                .header(HttpHeaders.SET_COOKIE, cookie.toString())
	                .body(Map.of("accessToken", tokens.getAccessToken()));
	    }

	    /**
	     * 2. 로그인 (비밀번호 검증 → 토큰 발급)
	     */
	    @PostMapping(value = "/login" )
	    public ResponseEntity<?> login(@RequestBody MemberEntity member) {
	        MemberEntity dbMember = memberService.findByMid(member.getMid(), member.getMpassword());

	        if (dbMember == null) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("id, pass invalid");
	        }

	        // 토큰 발급
	        String accessToken = jwtUtil.createAccessToken(member);
	        String refreshToken = jwtUtil.createRefreshToken(member);
	        memberService.updateRefreshToken(member.getMid(), refreshToken);

	        ResponseCookie cookie = ResponseCookie.from("refreshToken", refreshToken)
	                .httpOnly(true)
	                .secure(true)
	                .path("/api/token")
	                .maxAge(7 * 24 * 60 * 60)
	                .sameSite("Strict")
	                .build();

	        return ResponseEntity.ok()
	                .header(HttpHeaders.SET_COOKIE, cookie.toString())
	                .body(Map.of("accessToken", accessToken));
	    }

	    /**
	     * 3. accessToken 만료 후, refreshToken을 이용해 재발급
	     */
	    @PostMapping("/token/refresh")
	    public ResponseEntity<?> refresh(@CookieValue(name = "refreshToken", required = false) String refreshToken) {
	        if (refreshToken == null || !jwtUtil.validateToken(refreshToken)) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid Refresh Token");
	        }

	        String mid = jwtUtil.getUsernameFromToken(refreshToken);
	        MemberEntity member = memberService.findByMidOnly(mid);

	        if (member == null || !refreshToken.equals(member.getRefreshToken())) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("token not equals");
	        }

	        String newAccessToken = jwtUtil.createAccessToken(member);
	        return ResponseEntity.ok(Map.of("accessToken", newAccessToken));
	    }
}