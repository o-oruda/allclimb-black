package io.ooruda.allclimb.module.database.repository.ticket;

import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.ooruda.allclimb.module.database.entity.ticket.TicketInfo;
import io.ooruda.allclimb.module.database.entity.ticket.code.SaleStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static com.querydsl.jpa.JPAExpressions.selectFrom;
import static io.ooruda.allclimb.module.database.entity.ticket.QTicketInfo.ticketInfo;

@Getter
@RequiredArgsConstructor
public abstract class TicketBaseRepository {

    private final JPAQueryFactory queryFactory;

    public Optional<TicketInfo> findById(long id) {
        return Optional.ofNullable(
                selectFrom(ticketInfo)
                    .where(ticketInfo.id.eq(id))
                    .fetchOne()
        );
    }

    public JPQLQuery<TicketInfo> findAllSelect() {
        return selectFrom(ticketInfo)
                .where(ticketInfo.saleStatus.ne(SaleStatus.DELETE));
    }

}
