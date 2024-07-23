package io.ooruda.allclimb.user.global.common.code;

import io.ooruda.allclimb.user.global.common.dto.ErrorReasonDto;

public interface BaseErrorCode {
    public ErrorReasonDto getReason();

    public ErrorReasonDto getReasonHttpStatus();
}