package io.ooruda.allclimb.user.domain.payment.payment.error;

import io.ooruda.allclimb.user.common.response.code.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum TicketPaymentError implements ResponseCode {
    NOT_FOUND_TICKET(HttpStatus.NOT_FOUND, "ticket_payment.error.00001", "존재하지 않는 티켓입니다"),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;

}
