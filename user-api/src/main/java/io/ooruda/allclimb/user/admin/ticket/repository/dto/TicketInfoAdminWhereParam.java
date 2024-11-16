package io.ooruda.allclimb.user.admin.ticket.repository.dto;

import com.querydsl.core.types.dsl.BooleanExpression;
import io.ooruda.allclimb.module.database.entity.ticket.code.SaleStatus;
import io.ooruda.allclimb.module.database.repository.ticket.dto.TicketInfoDefaultWhereParam;
import io.ooruda.allclimb.user.admin.ticket.dto.TicketSearchDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Optional;

import static io.ooruda.allclimb.module.database.entity.ticket.QTicketInfo.ticketInfo;
import static io.ooruda.allclimb.module.database.utils.QueryDslWhereExpressions.containsIgnoreCase;
import static io.ooruda.allclimb.module.database.utils.QueryDslWhereExpressions.equalsEnum;

@Getter
@SuperBuilder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TicketInfoAdminWhereParam extends TicketInfoDefaultWhereParam {

    private SaleStatus saleStatus;
    private String adminId;

    public static TicketInfoAdminWhereParam of(final TicketSearchDto searchDto) {
        return TicketInfoAdminWhereParam.builder()
                .ticketType(searchDto.ticketType())
                .maxLimitPrice(searchDto.maxPrice())
                .minLimitPrice(searchDto.minPrice())
                .name(searchDto.name())
                .useGrade(searchDto.useGrade())
                .saleStatus(searchDto.saleStatus())
                .adminId(searchDto.adminId())
                .build();
    }

    @Override
    public List<BooleanExpression> getConditions() {
        List<BooleanExpression> conditions = super.getConditions();

        Optional.ofNullable(saleStatus).ifPresent(p -> conditions.add(equalsEnum(ticketInfo.saleStatus, p)));
        Optional.ofNullable(adminId).ifPresent(p -> conditions.add(
                containsIgnoreCase(ticketInfo.createdBy, p)
                        .or(containsIgnoreCase(ticketInfo.updatedBy, p))));
        return conditions;
    }

    @Override
    public BooleanExpression toWhere() {
        return getConditions().stream().reduce(BooleanExpression::and).orElse(null);
    }
}
