package com.shinhan.spring.springjwt;

import java.security.Key;
import java.time.ZonedDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtUtil {

	private final Key key;
	private final long accessTokenExpTime;
	private final long refreshTokenExpTime;

	public JwtUtil(@Value("${jwt.secret}") String secretKey,
	               @Value("${jwt.access_expiration_time}") long accessTokenExpTime,
	               @Value("${jwt.refresh_expiration_time}") long refreshTokenExpTime) {

		byte[] keyBytes = Decoders.BASE64.decode(secretKey);
		this.key = Keys.hmacShaKeyFor(keyBytes);
		this.accessTokenExpTime = accessTokenExpTime;
		this.refreshTokenExpTime = refreshTokenExpTime;
	}

	// ✅ Access Token 생성
	public String createAccessToken(MemberEntity member) {
		return createToken(member, accessTokenExpTime);
	}

	// ✅ Refresh Token 생성
	public String createRefreshToken(MemberEntity member) {
		return createToken(member, refreshTokenExpTime);
	}

	// ✅ 공통 토큰 생성
	private String createToken(MemberEntity member, long expireTime) {
		Claims claims = Jwts.claims();
		claims.put("mid", member.getMid());
		claims.put("mname", member.getMname());
		claims.put("mrole", member.getMember_mrole_data());

		ZonedDateTime now = ZonedDateTime.now();
		ZonedDateTime tokenValidity = now.plusSeconds(expireTime);

		return Jwts.builder()
				.setClaims(claims)
				.setIssuedAt(Date.from(now.toInstant()))
				.setExpiration(Date.from(tokenValidity.toInstant()))
				.signWith(key, SignatureAlgorithm.HS256)
				.compact();
	}

	// ✅ 토큰에서 사용자 ID 추출
	public String getUserId(String token) {
		return parseClaims(token).get("memberId", String.class);
	}

	// ✅ 토큰 유효성 검증
	public boolean validateToken(String token) {
		try {
			Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
			return true;
		} catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
			log.info("Invalid JWT Token", e);
		} catch (ExpiredJwtException e) {
			log.info("Expired JWT Token", e);
		} catch (UnsupportedJwtException e) {
			log.info("Unsupported JWT Token", e);
		} catch (IllegalArgumentException e) {
			log.info("JWT claims string is empty.", e);
		}
		return false;
	}

	// ✅ Claims 추출
	public Claims parseClaims(String token) {
		try {
			return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
		} catch (ExpiredJwtException e) {
			return e.getClaims();
		}
	}

	// ✅ 토큰에서 username 추출 (refresh 재발급용)
	public String getUsernameFromToken(String token) {
		return parseClaims(token).get("mid", String.class);
	}

	//만료test용 
	public String createShortLivedAccessToken(MemberEntity member, long seconds) {
		return createToken(member, seconds);
	}
}