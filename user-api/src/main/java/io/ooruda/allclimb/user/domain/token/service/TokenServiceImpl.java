package io.ooruda.allclimb.user.domain.token.service;

import io.ooruda.allclimb.user.domain.token.domain.dto.TokenDto;
import io.ooruda.allclimb.user.domain.token.domain.entity.RefreshToken;
import io.ooruda.allclimb.user.domain.token.exception.TokenErrorResult;
import io.ooruda.allclimb.user.domain.token.exception.TokenException;
import io.ooruda.allclimb.user.domain.token.repository.RefreshTokenRepository;
import io.ooruda.allclimb.user.global.util.CookieUtil;
import io.ooruda.allclimb.user.global.util.JwtUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {
    @Value("${jwt.access-token.expiration-time}")
    private long ACCESS_TOKEN_EXPIRATION_TIME; // 액세스 토큰 유효기간

    @Value("${jwt.refresh-token.expiration-time}")
    private long REFRESH_TOKEN_EXPIRATION_TIME; // 리프레쉬 토큰 유효기간

    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtUtil jwtUtil;
    private final CookieUtil cookieUtil;

    // 토큰 재발급
    @Override
    public TokenDto.TokenResponse reissueAccessToken(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = cookieUtil.getCookie(request);
        String refreshToken = cookie.getValue();
        UUID userId = UUID.fromString(jwtUtil.getUserIdFromToken(refreshToken));
        RefreshToken existRefreshToken = refreshTokenRepository.findByUuid(userId)
                .orElseThrow(() -> new TokenException(TokenErrorResult.REFRESH_TOKEN_NOT_FOUND));
        String newAccessToken;

        if (!existRefreshToken.getToken().equals(refreshToken) || jwtUtil.isTokenExpired(refreshToken)) {
            // 리프레쉬 토큰이 다르거나, 만료된 경우
            throw new TokenException(TokenErrorResult.INVALID_REFRESH_TOKEN); // 401 에러를 던져 재로그인을 요청
        } else {
            // 액세스 토큰 재발급
            newAccessToken = jwtUtil.generateAccessToken(userId, ACCESS_TOKEN_EXPIRATION_TIME);
        }

        // 리프레쉬 토큰이 담긴 쿠키 생성 후 설정
        ResponseCookie newCookie = cookieUtil.createCookie(userId, REFRESH_TOKEN_EXPIRATION_TIME);
        response.addHeader("Set-Cookie", newCookie.toString());

        // 새로운 리프레쉬 토큰 Redis 저장
//        RefreshToken newRefreshToken = new RefreshToken(userId, newCookie.getValue());
//        refreshTokenRepository.save(newRefreshToken);

        // 새로운 액세스 토큰을 담아 반환
        return TokenDto.TokenResponse.of(newAccessToken);
    }
}