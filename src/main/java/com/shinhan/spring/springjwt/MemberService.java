package com.shinhan.spring.springjwt;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;
	private final JwtUtil jwtUtil;

	// ȸ������ + ��ū �߱�
	public AccessRefreshTokenDTO insert(MemberEntity member) {
		// Mpassword��ȣȭ
		String hashedPassword = BCrypt.hashpw(member.getMpassword(), BCrypt.gensalt());
		member.setMpassword(hashedPassword);

		// ��ū�߱�
		String accessToken = jwtUtil.createAccessToken(member);
		String refreshToken = jwtUtil.createRefreshToken(member);
		member.setRefreshToken(refreshToken);

		// DB����
		memberRepository.insert(member);
		// �����ȯ
		return new AccessRefreshTokenDTO(accessToken, refreshToken);
	}

	public MemberEntity findByMid(String mid, String mpassword) {
		MemberEntity member = memberRepository.findByMid(mid);
		String hashed = member.getMpassword();
		boolean isMatch = BCrypt.checkpw(mpassword, hashed);
		System.out.println("��й�ȣ ��ġ ����: " + isMatch);
		return isMatch?member:null;
	}

	public MemberEntity findByMidOnly(String mid) {
		MemberEntity member = memberRepository.findByMid(mid);
 		return member;
	}
	
	public void updateRefreshToken(String mid, String refreshToken) {
		MemberEntity member = memberRepository.findByMid(mid);
		if (member == null)
			throw new RuntimeException("ȸ�� ����");
		member.setRefreshToken(refreshToken);
		memberRepository.updateRefreshToken(member);
	}

	public void removeRefreshToken(String mid) {
		MemberEntity member = memberRepository.findByMid(mid);
		if (member == null)
			throw new RuntimeException("ȸ�� ����");
		member.setRefreshToken(null);
		memberRepository.updateRefreshToken(member);
	}

}
