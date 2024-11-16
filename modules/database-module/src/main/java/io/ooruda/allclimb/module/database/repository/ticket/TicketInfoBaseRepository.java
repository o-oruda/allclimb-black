package io.ooruda.allclimb.module.database.repository.ticket;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.ooruda.allclimb.module.database.entity.ticket.TicketInfo;
import io.ooruda.allclimb.module.database.entity.ticket.code.SaleStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static io.ooruda.allclimb.module.database.entity.ticket.QTicketInfo.ticketInfo;

@Getter
@RequiredArgsConstructor
public abstract class TicketInfoBaseRepository {

    private final JPAQueryFactory queryFactory;

    public TicketInfo findById(long id) {
        return queryFactory.selectFrom(ticketInfo)
                    .where(ticketInfo.id.eq(id)
                        .and(ticketInfo.saleStatus.ne(SaleStatus.DELETE)))
                    .fetchOne();
    }

    public JPAQuery<TicketInfo> findAllSelect() {
        return queryFactory.selectFrom(ticketInfo)
                .where(ticketInfo.saleStatus.ne(SaleStatus.DELETE));
    }

}
