package io.ooruda.allclimb.user.admin.ticket.dto;

import io.ooruda.allclimb.module.database.entity.ticket.code.SaleStatus;
import java.math.BigDecimal;

public record TicketModifyRequest(
        BigDecimal price,
        String name,
        Integer minUseGrade,
        Integer maxUseGrade,
        Integer ticketCount,
        Integer validityDay,
        SaleStatus saleStatus
) {

}
