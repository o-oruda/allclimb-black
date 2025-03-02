package io.ooruda.allclimb.user.domain.ticket.dto;

import io.ooruda.allclimb.module.database.entity.ticket.TicketInfo;
import io.ooruda.allclimb.module.database.entity.ticket.code.TicketType;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record Ticket(
        long id,
        TicketType ticketType,
        String name,
        BigDecimal price,
        Integer minUseGrade,
        Integer maxUseGrade,
        Integer ticketCount,
        Integer validityDay
) {

    public static Ticket of(TicketInfo vo) {
        return Ticket.builder()
                .id(vo.getId())
                .ticketType(vo.getTicketType())
                .name(vo.getName())
                .price(vo.getPrice())
                .minUseGrade(vo.getMinUseGrade())
                .maxUseGrade(vo.getMaxUseGrade())
                .ticketCount(vo.getTicketCount())
                .validityDay(vo.getValidityDay())
                .build();
    }
}
