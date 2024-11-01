package io.ooruda.allclimb.user.common.response;

import io.ooruda.allclimb.user.common.response.code.CommonResponseCode;
import io.ooruda.allclimb.user.common.response.dto.ApiResponse;
import io.ooruda.allclimb.user.common.response.error.AllclimbException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    // 예외 발생 시 공통 에러 응답 반환
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleException(Exception ex) {

        ApiResponse<Object> response = ApiResponse.error(CommonResponseCode.ERROR);
        return new ResponseEntity<>(response, CommonResponseCode.ERROR.getStatus());
    }

    @ExceptionHandler(AllclimbException.class)
    public ResponseEntity<ApiResponse<Object>> allClimbException(AllclimbException ex) {

        ApiResponse<Object> response = ApiResponse.error(ex.getResponseCode());
        return new ResponseEntity<>(response, ex.getResponseCode().getStatus());
    }


}
