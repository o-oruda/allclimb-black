package io.ooruda.allclimb.user.domain.payment.kakao;

import com.nimbusds.jose.shaded.gson.Gson;
import io.ooruda.allclimb.module.database.entity.payment.PaymentList;
import io.ooruda.allclimb.user.domain.payment.kakao.dto.KakaoPaymentReadyRequest;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@RequiredArgsConstructor
@Service
public class KakaoPaymentService {

    private final KakaoPaymentConfigProp configProp;
    private final WebClient kakaoWebClient;
    private Gson gson = new Gson();

    public Map<String, Object> ready(PaymentList request) {
        log.info("kakao payment ready : {}", request);

        KakaoPaymentReadyRequest readyRequest = getRequest(request);
        String reqString = gson.toJson(readyRequest);
        log.info("kakao payment ready : {}", reqString);

        return kakaoWebClient
                .post()
                .uri("/online/v1/payment/ready")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(reqString)
                .retrieve()
                .bodyToMono(Map.class)
                .doOnSuccess(s -> log.info("payment ready {}", s))
                .doOnError(throwable -> log.error(throwable.getMessage(), throwable))
                .block();

    }

    public KakaoPaymentReadyRequest getRequest(PaymentList paymentList) {
        return KakaoPaymentReadyRequest.builder()
                .cid(configProp.getCid())
                .cid_secret(configProp.getCidSecret())
                .partner_user_id(configProp.getPartnerUserId())
                .partner_order_id(String.valueOf(paymentList.getId()))
                .item_name(paymentList.getItemName())
                .item_code(paymentList.getItemCode())
                .quantity(Integer.valueOf(paymentList.getQuantity().toString()))
                .total_amount(Integer.valueOf(paymentList.getQuantity().multiply(paymentList.getPrice()).toString()))
                .tax_free_amount(0)
                .approval_url("http://localhost:8080/api/v1/payments/tickets/success")
                .cancel_url("http://localhost:8080/api/v1/payments/tickets/cancel")
                .fail_url("http://localhost:8080/api/v1/payments/tickets/fail")
                .build();
    }
}
