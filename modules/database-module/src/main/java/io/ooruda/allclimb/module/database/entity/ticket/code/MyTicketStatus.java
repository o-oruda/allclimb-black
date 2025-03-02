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
public enum MyTicketStatus {
    READY("READY", "사용대기"),
    IN_USE("IN_USE", "사용중"),
    EXPIRE("EXPIRE", "만기"),
    CANCEL("CANCEL", "취소")
    ;

    @JsonValue
    private final String code;
    private final String desc;

    private static final Map<String, MyTicketStatus> myTicketStatusMap =
            Collections.unmodifiableMap(Stream.of(values()).collect(Collectors.toMap(MyTicketStatus::getCode, Function.identity())));

    public static MyTicketStatus fromCode(String code) {
        if (code == null) return null;
        return Optional.ofNullable(myTicketStatusMap.get(code))
                .orElseThrow(() -> new IllegalArgumentException(String.format("Unknown code '%s'", code)));
    }

}
