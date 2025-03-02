package io.ooruda.allclimb.user.domain.payment.kakao;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "payment.kakao")
public class KakaoPaymentConfigProp {

    private String secretKey;
    private String cid;
    private String cidSecret;
    private String partnerUserId;
}
