package io.ooruda.allclimb.module.database.entity.payment.code;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum PaymentState {
    READY("READY", "결제준비(요청)"),
    APPROVE("APPROVE", "결제승인"),
    FAILURE("FAIL", "결제실패")
    ;

    @JsonValue
    private final String code;
    private final String desc;

    private static final Map<String, PaymentState> paymentStateMap =
            Collections.unmodifiableMap(Stream.of(values()).collect(Collectors.toMap(PaymentState::getCode, Function.identity())));

    public static PaymentState fromCode(String code) {
        if (code == null) return null;
        return Optional.ofNullable(paymentStateMap.get(code))
                .orElseThrow(() -> new IllegalArgumentException(String.format("Unknown code '%s'", code)));
    }

}
