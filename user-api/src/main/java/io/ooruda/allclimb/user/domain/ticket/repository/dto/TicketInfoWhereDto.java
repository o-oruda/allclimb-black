package io.ooruda.allclimb.user.domain.ticket.repository.dto;

import com.querydsl.core.types.dsl.BooleanExpression;
import io.ooruda.allclimb.module.database.entity.ticket.code.SaleStatus;
import io.ooruda.allclimb.module.database.repository.ticket.dto.TicketInfoDefaultWhereParam;
import io.ooruda.allclimb.user.domain.ticket.api.request.TicketSearchDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import static io.ooruda.allclimb.module.database.entity.ticket.QTicketInfo.ticketInfo;
import static io.ooruda.allclimb.module.database.utils.QueryDslWhereExpressions.equalsEnum;

@Getter
@SuperBuilder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TicketInfoWhereDto extends TicketInfoDefaultWhereParam {

    public static TicketInfoWhereDto of(final TicketSearchDto searchDto) {
        return TicketInfoWhereDto.builder()
                .ticketType(searchDto.ticketType())
                .build();
    }

    @Override
    public BooleanExpression toWhere() {
        getConditions()
                .add(equalsEnum(ticketInfo.saleStatus, SaleStatus.ON_SALE)); // user-api 조회에서는 판매중인 목록만 조회되도록 해야함
        return getConditions().stream().reduce(BooleanExpression::and).orElse(null);
    }
}
