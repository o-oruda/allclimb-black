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

@AllArgsConstructor
@Getter
public enum PaymentType {
    PAYMENT("PAYMENT", "결제"),
    CANCEL("CANCEL", "취소"),
    RETURN("RETURN", "환불요청");
    ;

    @JsonValue
    private final String code;
    private final String desc;

    private static final Map<String, PaymentType> orderTypeMap =
            Collections.unmodifiableMap(Stream.of(values()).collect(Collectors.toMap(PaymentType::getCode, Function.identity())));

    public static PaymentType fromCode(final String code) {
        if (code == null) return null;
        return Optional.ofNullable(orderTypeMap.get(code))
                .orElseThrow(() -> new IllegalArgumentException(String.format("Unknown code '%s'", code)));
    }
}
