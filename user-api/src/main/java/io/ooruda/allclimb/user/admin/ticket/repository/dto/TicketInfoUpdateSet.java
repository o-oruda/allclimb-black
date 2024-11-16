package io.ooruda.allclimb.user.admin.ticket.repository.dto;

import com.querydsl.jpa.impl.JPAUpdateClause;
import io.ooruda.allclimb.module.database.entity.ticket.code.SaleStatus;
import io.ooruda.allclimb.user.admin.ticket.dto.TicketModifyRequest;
import jakarta.persistence.EntityManager;
import lombok.Builder;

import java.math.BigDecimal;

import static io.ooruda.allclimb.module.database.entity.ticket.QTicketInfo.ticketInfo;

@Builder
public record TicketInfoUpdateSet(
        BigDecimal price,
        String name,
        Integer minUseGrade,
        Integer maxUseGrade,
        Integer ticketCount,
        Integer validityDay,
        SaleStatus saleStatus
) {

    public static TicketInfoUpdateSet of(TicketModifyRequest request) {
        return TicketInfoUpdateSet.builder()
                .price(request.price())
                .name(request.name())
                .minUseGrade(request.minUseGrade())
                .maxUseGrade(request.maxUseGrade())
                .ticketCount(request.ticketCount())
                .validityDay(request.validityDay())
                .saleStatus(request.saleStatus())
                .build();
    }

    public JPAUpdateClause toUpdateSet(EntityManager em) {
        JPAUpdateClause updateSet = new JPAUpdateClause(em, ticketInfo);

        if (price != null && price.compareTo(BigDecimal.ZERO) >= 0) {
            updateSet.set(ticketInfo.price, price);
        }
        if (name != null) {
            updateSet.set(ticketInfo.name, name);
        }
        if (minUseGrade != null && minUseGrade >= 0) {
            updateSet.set(ticketInfo.minUseGrade, minUseGrade);
        }
        if (maxUseGrade != null && maxUseGrade >= 0) {
            updateSet.set(ticketInfo.maxUseGrade, maxUseGrade);
        }
        if (ticketCount != null && ticketCount >= 0) {
            updateSet.set(ticketInfo.ticketCount, ticketCount);
        }
        if (validityDay != null && validityDay >= 0) {
            updateSet.set(ticketInfo.validityDay, validityDay);
        }
        if (saleStatus != null) {
            updateSet.set(ticketInfo.saleStatus, saleStatus);
        }
        return updateSet;
    }
}
