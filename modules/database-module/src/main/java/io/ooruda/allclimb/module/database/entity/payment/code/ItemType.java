package io.ooruda.allclimb.module.database.entity.payment.code;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum ItemType {
    TICKET("TICKET", "tickets")
    ;

    @JsonValue
    private final String code;
    private final String desc;

    public static ItemType fromCode(String code) {
        if (code == null) return null;
        return Arrays.stream(values())
                .filter(itemType -> itemType.code.equals(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Unknown code '%s'", code)));
    }

}
