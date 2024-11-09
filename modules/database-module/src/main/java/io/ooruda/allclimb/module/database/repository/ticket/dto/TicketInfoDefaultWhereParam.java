package io.ooruda.allclimb.module.database.repository.ticket.dto;

import com.querydsl.core.types.dsl.BooleanExpression;
import io.ooruda.allclimb.module.database.entity.ticket.code.TicketType;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static io.ooruda.allclimb.module.database.entity.ticket.QTicketInfo.ticketInfo;
import static io.ooruda.allclimb.module.database.utils.QueryDslWhereExpressions.*;

@Getter
@SuperBuilder
@NoArgsConstructor
public abstract class TicketInfoDefaultWhereParam {

    private TicketType ticketType;
    private BigDecimal maxLimitPrice;
    private BigDecimal minLimitPrice;
    private String name;
    private Integer useGrade;

    public List<BooleanExpression> getConditions() {
        List<BooleanExpression> conditions = new ArrayList<>();

        Optional.ofNullable(ticketType).ifPresent(p -> conditions.add(equalsEnum(ticketInfo.ticketType, p)));
        Optional.ofNullable(maxLimitPrice).ifPresent(p -> conditions.add(greaterThan(ticketInfo.price, p)));
        Optional.ofNullable(minLimitPrice).ifPresent(p -> conditions.add(lessThan(ticketInfo.price, p)));
        Optional.ofNullable(name).ifPresent(p -> conditions.add(containsIgnoreCase(ticketInfo.name, p)));
        Optional.ofNullable(useGrade).ifPresent(
                p -> conditions.add(greaterThan(ticketInfo.minUseGrade, p)
                        .and(lessThan(ticketInfo.maxUseGrade, p))));
        return conditions;
    }

    public abstract BooleanExpression toWhere();
}
