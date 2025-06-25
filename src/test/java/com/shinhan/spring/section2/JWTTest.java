package com.shinhan.spring.section2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.shinhan.spring.springjwt.AccessRefreshTokenDTO;
import com.shinhan.spring.springjwt.JwtUtil;
import com.shinhan.spring.springjwt.MemberEntity;
import com.shinhan.spring.springjwt.MemberRoleEnum;
import com.shinhan.spring.springjwt.MemberService;

import io.jsonwebtoken.Claims;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = { 
		"file:src/main/webapp/WEB-INF/spring/root-context-oracle.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context-tx.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context-no.xml" })
@TestInstance(Lifecycle.PER_CLASS)
public class JWTTest {

	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	MemberService memberService;

	// 테스트용 secretKey (HS256을 위해 최소 256bit = 32bytes 이상 필요)
	// private final String secretKey =
	// Base64.getEncoder().encodeToString("my-test-jwt-secret-key-1234567890".getBytes());

	@BeforeAll
	void setUp() {
		// 60초 유효기간
		// jwtUtil = new JwtUtil(secretKey, 60);
	}

	//@Test
	public void testJwtUtilIsLoaded() {
		assertNotNull(jwtUtil);
		// 필요시 리플렉션이나 메서드 추가로 내부 필드 확인
	}

	//1.회원가입
	@Test
	 public void insertTest() {
		 MemberEntity member = MemberEntity.builder()
				 .mid("zzilre3")
				 .mpassword("1234")
				 .mname("jin3")
				 .member_mrole_data(MemberRoleEnum.ADMIN)
				 .build();
		 AccessRefreshTokenDTO token = memberService.insert(member);
		 System.out.println(token);
	 }
	//2. mid로 Member얻기 
	//@Test
	public void getmember() {
		 String inputPass = "1234";
		 MemberEntity member = memberService.findByMid("zzilre",inputPass );
		 System.out.println(member);
	}
 	
	//@Test
	void testCreateAccessToken() {
		// given
		 String inputPass = "1234";
		 MemberEntity member = memberService.findByMid("zzilre",inputPass );
		// when
		String token = jwtUtil.createAccessToken(member);
		// then
		assertNotNull(token);
		System.out.println("생성된 토큰: " + token);
		Claims claims = jwtUtil.parseClaims(token);
		assertEquals(member.getMid(), claims.get("mid"));
		assertEquals(member.getMname(), claims.get("mname"));
		assertEquals(member.getMember_mrole_data(), claims.get("mrole"));
	}

	//@Test
	void testValidateToken() {
		MemberEntity member = MemberEntity.builder().mid("zzilre").mname("jin").member_mrole_data(MemberRoleEnum.USER).build();
		String token = jwtUtil.createAccessToken(member);
		boolean result = jwtUtil.validateToken(token);
		assertTrue(result, "토큰이 유효해야 합니다.");
	}
	
	//만료test
	//@Test
    public void accessToken_만료_테스트() throws InterruptedException {
        //1.회원조회
		String inputPass = "1234";
		MemberEntity member = memberService.findByMid("zzilre",inputPass );
		assertNotNull(member);
		
        //  2. Access Token (1초짜리) 발급
        String shortAccessToken = jwtUtil.createShortLivedAccessToken(member, 1L);
        System.out.println("shortAccessToken: " + shortAccessToken);
        
        //  3. 토큰이 아직 살아있을 수 있으므로 2초 대기 → 만료 유도
        Thread.sleep(2000);
        
        
        //  4. Access Token 유효성 검사 (만료되어야 함)
        boolean isValid = jwtUtil.validateToken(shortAccessToken);
        assertFalse(isValid, "AccessToken은 만료되어야 합니다.");
        
        
        //5. Refresh Token 생성 및 DB 저장
        String refreshToken = jwtUtil.createRefreshToken(member);
        member.setRefreshToken(refreshToken);
        memberService.updateRefreshToken(member.getMid(), refreshToken);  // repository 경유 저장

    
        // 6. RefreshToken 검증
        boolean refreshValid = jwtUtil.validateToken(refreshToken);
        assertTrue(refreshValid, "RefreshToken은 유효해야 합니다.");

        // 7. RefreshToken에서 mid 추출
        String mid = jwtUtil.getUsernameFromToken(refreshToken);
        System.out.println("mid:" + mid);
        MemberEntity memberFromDB = memberService.findByMidOnly(mid);
        System.out.println(memberFromDB);
        assertEquals(refreshToken, memberFromDB.getRefreshToken(), "DB와 토큰이 일치해야 함");

        // 8. AccessToken 재발급
        String newAccessToken = jwtUtil.createAccessToken(memberFromDB);
        assertNotNull(newAccessToken);
        System.out.println("재발급된 AccessToken: " + newAccessToken);

        // 9. 새 AccessToken 유효성 확인
        assertTrue(jwtUtil.validateToken(newAccessToken));
	}
}
