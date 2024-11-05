package io.ooruda.allclimb.user.common.response.dto;

import io.ooruda.allclimb.user.common.response.code.CommonResponseCode;
import io.ooruda.allclimb.user.common.response.code.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiResponse<T> {

    private String code;
    private String message;
    private T data;

    public ApiResponse(ResponseCode code, T data) {
        this.code = code.getCode();
        this.message = code.getMessage();
        this.data = data;
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(CommonResponseCode.SUCCESS, data);
    }

    public static <T> ApiResponse<T> error(ResponseCode errorCode) {
        return new ApiResponse<>(errorCode, null);
    }
}
