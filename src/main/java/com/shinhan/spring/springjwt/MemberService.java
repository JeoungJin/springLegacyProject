package com.shinhan.spring.springjwt;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;
	private final JwtUtil jwtUtil;

	// 회원가입 + 토큰 발급
	public AccessRefreshTokenDTO insert(MemberEntity member) {
		// Mpassword암호화
		String hashedPassword = BCrypt.hashpw(member.getMpassword(), BCrypt.gensalt());
		member.setMpassword(hashedPassword);

		// 토큰발급
		String accessToken = jwtUtil.createAccessToken(member);
		String refreshToken = jwtUtil.createRefreshToken(member);
		member.setRefreshToken(refreshToken);

		// DB저장
		memberRepository.insert(member);
		// 결과반환
		return new AccessRefreshTokenDTO(accessToken, refreshToken);
	}

	public MemberEntity findByMid(String mid, String mpassword) {
		MemberEntity member = memberRepository.findByMid(mid);
		String hashed = member.getMpassword();
		boolean isMatch = BCrypt.checkpw(mpassword, hashed);
		System.out.println("비밀번호 일치 여부: " + isMatch);
		return isMatch?member:null;
	}

	public MemberEntity findByMidOnly(String mid) {
		MemberEntity member = memberRepository.findByMid(mid);
 		return member;
	}
	
	public void updateRefreshToken(String mid, String refreshToken) {
		MemberEntity member = memberRepository.findByMid(mid);
		if (member == null)
			throw new RuntimeException("회원 없음");
		member.setRefreshToken(refreshToken);
		memberRepository.updateRefreshToken(member);
	}

	public void removeRefreshToken(String mid) {
		MemberEntity member = memberRepository.findByMid(mid);
		if (member == null)
			throw new RuntimeException("회원 없음");
		member.setRefreshToken(null);
		memberRepository.updateRefreshToken(member);
	}

}
