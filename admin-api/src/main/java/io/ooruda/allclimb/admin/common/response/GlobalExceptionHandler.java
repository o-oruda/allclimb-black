package io.ooruda.allclimb.admin.common.response;

import io.ooruda.allclimb.admin.common.response.code.CommonResponseCode;
import io.ooruda.allclimb.admin.common.response.dto.ApiResponse;
import io.ooruda.allclimb.admin.common.response.error.AllclimbException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    // 예외 발생 시 공통 에러 응답 반환
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleException(Exception ex) {

        ApiResponse<Object> response = ApiResponse.error(CommonResponseCode.ERROR);
        ex.printStackTrace();
        return new ResponseEntity<>(response, CommonResponseCode.ERROR.getStatus());
    }

    @ExceptionHandler(AllclimbException.class)
    public ResponseEntity<ApiResponse<Object>> allClimbException(AllclimbException ex) {

        ApiResponse<Object> response = ApiResponse.error(ex.getResponseCode());
        return new ResponseEntity<>(response, ex.getResponseCode().getStatus());
    }


}
