package com.duriyou.lean.web;

import com.duriyou.lean.domain.users.Users;
import com.duriyou.lean.security.JwtTokenProvider;
import com.duriyou.lean.service.users.UsersService;
import com.duriyou.lean.web.dto.Users.*;
import com.duriyou.lean.web.dto.token.TokenResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class UserApiController {
    private final UsersService usersService;
    private final JwtTokenProvider jwtTokenProvider;

    @GetMapping("/api/v1/users")
    public List<AllUsersResponseDto> getAllUsers() {
        return usersService.findAll();
    }

    @PostMapping("/api/v1/users")
    public Long save(@RequestBody UsersSaveRequestDto requestDto) {
        return usersService.save(requestDto);
    }

    @GetMapping("/api/v1/users/{id}")
    public UsersResponseDto findById(@PathVariable Long id) {
        return usersService.findById(id);
    }

    @PutMapping("/api/v1/users/{id}")
    public Long update(@PathVariable Long id, @RequestBody UsersUpdateRequestDto requestDto) {
        return usersService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/users/{id}")
    public Long delete(@PathVariable Long id) {
        usersService.delete(id);
        return id;
    }

    @PutMapping("api/v1/users/is-student-council/{id}")
    public Boolean update(@PathVariable Long id) {
        return usersService.updateIsStudentCouncil(id);
    }

    @PostMapping("/api/v1/signin")
    public Map<String, String> signin(@RequestBody SigninRequestDto requestDto) {
        Users user = usersService.authenticate(requestDto.getStudentNumber(), requestDto.getPassword());

        // Long -> String으로 변환하여 accessToken, refreshToken 생성
        String accessToken = jwtTokenProvider.generateToken(String.valueOf(user.getId()), true);
        String refreshToken = jwtTokenProvider.generateToken(String.valueOf(user.getId()), false);

        // 응답 Map 생성
        Map<String, String> tokenResponse = new HashMap<>();
        tokenResponse.put("accessToken", accessToken);
        tokenResponse.put("refreshToken", refreshToken);

        return tokenResponse;
    }



    @PostMapping("/api/v1/token/refresh")
    public ResponseEntity<?> refreshAccessToken(@RequestBody String refreshToken) {
        try {
            // Refresh Token을 검증하고, 유효한 경우 새로운 Access Token 및 Refresh Token 발급
            if (!jwtTokenProvider.validateToken(refreshToken)) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid refresh token");
            }

            // Refresh Token에서 user 정보(예: 사용자 ID) 추출
            String userId = jwtTokenProvider.getUserIdFromToken(refreshToken);

            // Long -> String으로 변환하여 Access Token 및 Refresh Token 생성
            String newAccessToken = jwtTokenProvider.generateToken(userId, true);  // Access Token
            String newRefreshToken = jwtTokenProvider.generateToken(userId, false); // Refresh Token

            // 응답 데이터 반환
            return ResponseEntity.ok(new TokenResponseDto(newAccessToken, newRefreshToken));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error refreshing token");
        }
    }



}
