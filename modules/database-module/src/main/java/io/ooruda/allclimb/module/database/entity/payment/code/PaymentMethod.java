package io.ooruda.allclimb.module.database.entity.payment.code;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum PaymentMethod {

    KAKAO("KAKAO", "KAKAO")
    ;

    @JsonValue
    private final String code;
    private final String desc;

    public static PaymentMethod fromCode(String code) {
        if (code == null) return null;
        return Arrays.stream(values())
                .filter(paymentMethod -> paymentMethod.code.equals(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Unknown code '%s'", code)));
    }

}
