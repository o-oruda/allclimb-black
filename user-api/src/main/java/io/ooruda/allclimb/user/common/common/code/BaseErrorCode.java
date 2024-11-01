package io.ooruda.allclimb.user.common.common.code;

import io.ooruda.allclimb.user.common.common.dto.ErrorReasonDto;

public interface BaseErrorCode {
    public ErrorReasonDto getReason();

    public ErrorReasonDto getReasonHttpStatus();
}