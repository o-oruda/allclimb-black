package io.ooruda.allclimb.user.domain.security.dto;

public interface OAuth2UserInfo {
    String getProviderId();

    String getProvider();

    String getName();
}