package com.shinhan.spring.springjwt;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccessRefreshTokenDTO {
    private String accessToken;
    private String refreshToken;
}
