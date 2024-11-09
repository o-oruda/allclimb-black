package io.ooruda.allclimb.admin.common.response.error;

import io.ooruda.allclimb.admin.common.response.code.ResponseCode;
import lombok.Getter;

@Getter
public class AllclimbException extends RuntimeException {

    private final ResponseCode responseCode;

    public AllclimbException(ResponseCode responseCode) {
        super(responseCode.getMessage());
        this.responseCode = responseCode;
    }
}
