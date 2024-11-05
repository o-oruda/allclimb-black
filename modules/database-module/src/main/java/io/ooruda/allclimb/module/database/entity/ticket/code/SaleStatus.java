package io.ooruda.allclimb.module.database.entity.ticket.code;

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
public enum SaleStatus {

    ON_SALE("01", "판매중"),
    OFF_SALE("02", "판매중지")
    ;

    @JsonValue
    private final String code;
    private final String desc;

    private static final Map<String, SaleStatus> saleStatusMap =
            Collections.unmodifiableMap(Stream.of(values()).collect(Collectors.toMap(SaleStatus::getCode, Function.identity())));

    public static SaleStatus fromCode(String code) {
        return Optional.ofNullable(code)
                .map(saleStatusMap::get)
                .orElse(OFF_SALE);
    }
}
