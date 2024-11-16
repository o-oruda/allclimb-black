package io.ooruda.allclimb.user.domain.ticket.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import io.ooruda.allclimb.module.database.entity.ticket.TicketInfo;
import io.ooruda.allclimb.module.database.repository.ticket.TicketInfoBaseRepository;
import io.ooruda.allclimb.user.domain.ticket.repository.dto.TicketInfoWhereDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TicketInfoRepository extends TicketInfoBaseRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public TicketInfoRepository(JPAQueryFactory queryFactory) {
        super(queryFactory);
    }

    public List<TicketInfo> findAllSelect(TicketInfoWhereDto whereDto) {
        return findAllSelect()
                .where(whereDto.toWhere())
                .fetch();
    }


}
