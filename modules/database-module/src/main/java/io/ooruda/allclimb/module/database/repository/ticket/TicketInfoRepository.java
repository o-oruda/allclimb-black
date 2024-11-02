package io.ooruda.allclimb.module.database.repository.ticket;

import com.querydsl.jpa.impl.JPAQueryFactory;
import io.ooruda.allclimb.module.database.entity.ticket.TicketInfo;
import io.ooruda.allclimb.module.database.repository.ticket.dto.TicketInfoWhereParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static io.ooruda.allclimb.module.database.entity.ticket.QTicketInfo.ticketInfo;
import static io.ooruda.allclimb.module.database.utils.QueryDslWhereExpressions.*;

@RequiredArgsConstructor
@Repository
public class TicketInfoRepository {

    private final JPAQueryFactory queryFactory;

    public List<TicketInfo> findAllByWhere(TicketInfoWhereParam whereParam) {
        return queryFactory.selectFrom(ticketInfo)
                .where(
                    equalsEnum(whereParam.getTicketType(), ticketInfo.ticketType),
                    greaterThan(whereParam.getGtPrice(), ticketInfo.price),
                    lessThan(whereParam.getLtPrice(), ticketInfo.price),
                    containsIgnoreCase(whereParam.getName(), ticketInfo.name),
                    greaterThan(whereParam.getUseGrade(), ticketInfo.minUseGrade),
                    lessThan(whereParam.getUseGrade(), ticketInfo.maxUseGrade),
                    equalsEnum(whereParam.getSaleStatus(), ticketInfo.saleStatus)
                )
                .fetch();
    }

    public TicketInfo findById(long id) {
        return queryFactory.selectFrom(ticketInfo)
                .where(ticketInfo.id.eq(id))
                .fetchOne();
    }

}
