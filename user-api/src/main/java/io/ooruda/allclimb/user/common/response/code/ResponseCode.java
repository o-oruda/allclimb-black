package io.ooruda.allclimb.user.common.response.code;

import org.springframework.http.HttpStatus;

public interface ResponseCode {
    HttpStatus getStatus();
    String getCode();
    String getMessage();
}
