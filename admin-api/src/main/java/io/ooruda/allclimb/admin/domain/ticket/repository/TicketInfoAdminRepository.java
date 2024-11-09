package io.ooruda.allclimb.admin.domain.ticket.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import io.ooruda.allclimb.admin.domain.ticket.repository.dto.TicketInfoAdminWhere;
import io.ooruda.allclimb.module.database.entity.ticket.TicketInfo;
import io.ooruda.allclimb.module.database.repository.ticket.TicketBaseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

import static io.ooruda.allclimb.module.database.entity.ticket.QTicketInfo.ticketInfo;

@Repository
public class TicketInfoAdminRepository extends TicketBaseRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public TicketInfoAdminRepository(JPAQueryFactory queryFactory) {
        super(queryFactory);
    }

    public List<TicketInfo> findAllSelect(TicketInfoAdminWhere whereParams) {
        return findAllSelect()
                //.where(whereParams.toWhere())
                .fetch();
    }

    public void create(TicketInfo newTicket) {

        entityManager.persist(newTicket);
    }
}
