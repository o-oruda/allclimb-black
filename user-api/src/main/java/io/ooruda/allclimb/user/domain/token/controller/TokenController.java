package io.ooruda.allclimb.user.domain.token.controller;

import io.ooruda.allclimb.user.domain.token.domain.dto.TokenDto;
import io.ooruda.allclimb.user.domain.token.service.TokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TokenController {
    private final TokenService authService;

    // 액세스 토큰을 재발행하는 API
    @GetMapping("/reissue/access-token")
    public ResponseEntity<?> reissueAccessToken(HttpServletRequest request, HttpServletResponse response) {

        TokenDto.TokenResponse accessToken = authService.reissueAccessToken(request, response);
        return ResponseEntity.ok(accessToken);
//        return ApiResponse.onSuccess(SuccessStatus._CREATED_ACCESS_TOKEN, accessToken);
    }
}