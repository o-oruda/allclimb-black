package io.ooruda.allclimb.admin.domain.ticket.error;

import io.ooruda.allclimb.admin.common.response.code.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum TicketError implements ResponseCode {
    NOT_FOUND_TICKET(HttpStatus.NOT_FOUND, "ticket.error.00001", "존재하지 않는 티켓입니다"),
    CREATE_ERROR(HttpStatus.BAD_REQUEST, "ticket.error.00002", "ticket create error")
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
