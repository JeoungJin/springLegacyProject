package com.shinhan.spring.springjwt;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String mid;
    private String mpassword;
}
