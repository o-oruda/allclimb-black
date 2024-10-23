package io.ooruda.allclimb.module.database.entity.pass.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum PassType {

    PERIOD("01", "기간권"),
    COUNT("02", "횟수권")
    ;

    private final String code;
    private final String desc;

    private static Map<String, PassType> map = Collections.unmodifiableMap(Stream.of(values())
            .collect(Collectors.toMap(PassType::getCode, Function.identity())));

    public static PassType fromCode(String code) {
        return map.get(code);
    }

}
