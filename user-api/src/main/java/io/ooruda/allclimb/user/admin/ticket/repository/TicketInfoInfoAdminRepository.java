package io.ooruda.allclimb.user.admin.ticket.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import io.ooruda.allclimb.module.database.entity.ticket.TicketInfo;
import io.ooruda.allclimb.module.database.entity.ticket.code.SaleStatus;
import io.ooruda.allclimb.module.database.repository.ticket.TicketInfoBaseRepository;
import io.ooruda.allclimb.user.admin.ticket.repository.dto.TicketInfoAdminWhereParam;
import io.ooruda.allclimb.user.admin.ticket.repository.dto.TicketInfoUpdateSet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;

import static io.ooruda.allclimb.module.database.entity.ticket.QTicketInfo.ticketInfo;

@Slf4j
@Repository
public class TicketInfoInfoAdminRepository extends TicketInfoBaseRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public TicketInfoInfoAdminRepository(JPAQueryFactory queryFactory) {
        super(queryFactory);
    }

    public List<TicketInfo> findAllSelect(TicketInfoAdminWhereParam whereDto) {
        return findAllSelect()
                .where(whereDto.toWhere())
                .fetch();
    }

    @Modifying
    public long create(TicketInfo newTicket) {
        entityManager.persist(newTicket);
        return newTicket.getId();
    }

    @Modifying
    public long update(long ticketId, TicketInfoUpdateSet ticketInfoUpdateSet) {

        JPAUpdateClause updateSet = ticketInfoUpdateSet.toUpdateSet(entityManager);
        return updateSet.where(ticketInfo.id.eq(ticketId)).execute();
    }

    @Modifying
    public long delete(long id) {
        return getQueryFactory().update(ticketInfo)
                .set(ticketInfo.saleStatus, SaleStatus.DELETE)
                .where(ticketInfo.id.eq(id))
                .execute();
    }
}
