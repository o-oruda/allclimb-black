package io.ooruda.allclimb.user.domain.payment.payment.dto;

import io.ooruda.allclimb.module.database.entity.payment.code.ItemType;
import io.ooruda.allclimb.module.database.entity.payment.code.PaymentMethod;
import io.ooruda.allclimb.module.database.entity.payment.code.PaymentState;
import io.ooruda.allclimb.module.database.entity.payment.code.PaymentType;
import io.ooruda.allclimb.module.database.entity.ticket.TicketInfo;
import io.ooruda.allclimb.user.domain.payment.kakao.dto.KakaoPaymentReadyRequest;
import java.math.BigDecimal;
import lombok.Builder;

@Builder
public record PaymentRequest(

        Long memberId,
        PaymentMethod paymentMethod,
        PaymentType paymentType,
        ItemType itemType,
        Long itemId,
        String itemCode,
        String itemName,
        BigDecimal qty,
        BigDecimal price,
        PaymentState state
) {

    public static PaymentRequest ofTicket(TicketInfo ticketInfo) {
        return PaymentRequest.builder()
                .paymentMethod(PaymentMethod.KAKAO)
                .paymentType(PaymentType.PAYMENT)
                .itemType(ItemType.TICKET)
                .itemId(ticketInfo.getId())
                .itemCode(ItemType.TICKET.getCode() + "-" + ticketInfo.getId())
                .itemName(ticketInfo.getName())
                .qty(BigDecimal.ONE)
                .price(ticketInfo.getPrice())
                .state(PaymentState.READY)
                .build();
    }

    public KakaoPaymentReadyRequest toKakao() {
        return KakaoPaymentReadyRequest.builder()

                .build();
    }

}
