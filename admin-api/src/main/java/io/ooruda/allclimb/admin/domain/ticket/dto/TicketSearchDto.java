package io.ooruda.allclimb.admin.domain.ticket.dto;

import io.ooruda.allclimb.module.database.entity.ticket.code.SaleStatus;
import io.ooruda.allclimb.module.database.entity.ticket.code.TicketType;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record TicketSearchDto(
        TicketType ticketType,
        BigDecimal minPrice,
        BigDecimal maxPrice,
        String name,
        Integer useGrade,
        SaleStatus saleStatus,
        String adminId
) {
}
