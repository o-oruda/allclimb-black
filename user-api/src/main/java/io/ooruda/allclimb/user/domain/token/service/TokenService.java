package io.ooruda.allclimb.user.domain.token.service;

import io.ooruda.allclimb.user.domain.token.domain.dto.TokenDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface TokenService {
    TokenDto.TokenResponse reissueAccessToken(HttpServletRequest request, HttpServletResponse response);
}
