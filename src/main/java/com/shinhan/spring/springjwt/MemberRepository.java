package com.shinhan.spring.springjwt;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberRepository {
	
	public MemberEntity findByMid(String mid) ; 
	public void insert(MemberEntity member); 
	public void updateRefreshToken(MemberEntity member);
	 
}
