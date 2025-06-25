package com.shinhan.spring.springjwt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberEntity {
 
	    private String mid;     // memberId
	    private String mname;   // member name
	    private String mpassword;
	    private MemberRoleEnum member_mrole_data;   // member role (ex: USER, ADMIN µî)
	    private String refreshToken;
	    
}
