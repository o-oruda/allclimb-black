package io.ooruda.allclimb.user.domain.payment.kakao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class KakaoWebClientConfig {

    @Value("${payment.kakao.secretKey}")
    private String secretKey;

    @Bean
    public WebClient kakaoWebClient() {
        return WebClient.builder()
                .baseUrl("https://open-api.kakaopay.com")
                .defaultHeaders(headers -> {
                    headers.add(HttpHeaders.HOST, "open-api.kakaopay.com");
                    headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
                    headers.add(HttpHeaders.AUTHORIZATION, "SECRET_KEY " + secretKey);
                })
                .build();
    }

}
