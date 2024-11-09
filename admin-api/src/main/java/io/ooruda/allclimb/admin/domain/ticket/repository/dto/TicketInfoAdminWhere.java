package io.ooruda.allclimb.admin.domain.ticket.repository.dto;

import com.querydsl.core.types.dsl.BooleanExpression;
import io.ooruda.allclimb.module.database.entity.ticket.code.SaleStatus;
import io.ooruda.allclimb.module.database.repository.ticket.dto.TicketInfoDefaultWhereParam;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Optional;

import static io.ooruda.allclimb.module.database.entity.ticket.QTicketInfo.ticketInfo;
import static io.ooruda.allclimb.module.database.utils.QueryDslWhereExpressions.*;

@Getter
@SuperBuilder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TicketInfoAdminWhere extends TicketInfoDefaultWhereParam {

    private SaleStatus saleStatus;
    private String adminId;

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
