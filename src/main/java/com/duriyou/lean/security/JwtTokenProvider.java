package com.duriyou.lean.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.access-token-validity}")
    private Long accessTokenValidity;

    @Value("${jwt.refresh-token-validity}")
    private Long refreshTokenValidity;

    // Access Token 생성
    public String generateToken(String userId, boolean isAccessToken) {
        long validity = isAccessToken ? accessTokenValidity : refreshTokenValidity;
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + validity);  // 유효 기간 적용

        return Jwts.builder()
                .claim("user_id", userId)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }

    // Refresh Token 생성
    public String generateRefreshToken(String userId) {
        return generateToken(userId, false);  // Refresh Token의 경우 false로 지정
    }

    // Access Token 생성
    public String generateAccessToken(String userId) {
        return generateToken(userId, true);  // Access Token의 경우 true로 지정
    }

    // 토큰 유효성 검사
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 토큰에서 사용자 정보 추출
    public String getUserIdFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();
        return claims.get("user_id", String.class);
    }
}
