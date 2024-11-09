package io.ooruda.allclimb.admin.common.response.code;

import org.springframework.http.HttpStatus;

public interface ResponseCode {
    HttpStatus getStatus();
    String getCode();
    String getMessage();
}
