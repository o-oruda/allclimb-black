package io.ooruda.allclimb.user.common.response.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum CommonResponseCode implements ResponseCode {
    SUCCESS(HttpStatus.OK, "common.success.00001", "Success"),
    ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "common.error.00001", "Internal Server Error"),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;

}
