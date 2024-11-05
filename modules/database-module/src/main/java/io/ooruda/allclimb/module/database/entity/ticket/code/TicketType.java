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

@Getter
@AllArgsConstructor
public enum TicketType {

    UNKNOWN("00", "unknown tickets"),
    PERIOD("01", "기간권"),
    COUNT("02", "횟수권")
    ;

    @JsonValue
    private final String code;
    private final String desc;

    private static final Map<String, TicketType> ticketTypeMap = Collections.unmodifiableMap(Stream.of(values())
            .collect(Collectors.toMap(TicketType::getCode, Function.identity())));

    public static TicketType fromCode(String code) {
        return Optional.ofNullable(code)
                .map(ticketTypeMap::get)
                .orElse(UNKNOWN);
    }

}
