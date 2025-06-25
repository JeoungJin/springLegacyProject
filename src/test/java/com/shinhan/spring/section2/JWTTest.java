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
 

	//@Test
	public void testJwtUtilIsLoaded() {
		assertNotNull(jwtUtil);
		 
	}

 
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
	//2. mid 
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
		System.out.println("testCreateAccessToken: " + token);
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
		assertTrue(result, "testValidateToken.");
	}
 
	//@Test
    public void accessToken_1() throws InterruptedException {
        //1.ȸ 
		String inputPass = "1234";
		MemberEntity member = memberService.findByMid("zzilre",inputPass );
		assertNotNull(member);
		
        //  2. Access Token  
        String shortAccessToken = jwtUtil.createShortLivedAccessToken(member, 1L);
        System.out.println("shortAccessToken: " + shortAccessToken);
        
        //  3.  
        Thread.sleep(2000);
        
        
        //  4. Access Token  
        boolean isValid = jwtUtil.validateToken(shortAccessToken);
        assertFalse(isValid, "AccessToken  .");
        
        
        //5. Refresh Token  
        String refreshToken = jwtUtil.createRefreshToken(member);
        member.setRefreshToken(refreshToken);
        memberService.updateRefreshToken(member.getMid(), refreshToken);  // repository  

    
        // 6. RefreshToken  
        boolean refreshValid = jwtUtil.validateToken(refreshToken);
        assertTrue(refreshValid, "RefreshToken ");

        // 7. RefreshToken 
        String mid = jwtUtil.getUsernameFromToken(refreshToken);
        System.out.println("mid:" + mid);
        MemberEntity memberFromDB = memberService.findByMidOnly(mid);
        System.out.println(memberFromDB);
        assertEquals(refreshToken, memberFromDB.getRefreshToken(), "DB ");

        // 8. AccessToken 
        String newAccessToken = jwtUtil.createAccessToken(memberFromDB);
        assertNotNull(newAccessToken);
        System.out.println("��߱޵� AccessToken: " + newAccessToken);

        // 9.   AccessToken 
        assertTrue(jwtUtil.validateToken(newAccessToken));
	}
}
