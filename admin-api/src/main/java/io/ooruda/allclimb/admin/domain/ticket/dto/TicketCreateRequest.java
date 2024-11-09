package io.ooruda.allclimb.admin.domain.ticket.dto;

import io.ooruda.allclimb.admin.common.response.error.AllclimbException;
import io.ooruda.allclimb.admin.domain.ticket.error.TicketError;
import io.ooruda.allclimb.module.database.entity.ticket.TicketInfo;
import io.ooruda.allclimb.module.database.entity.ticket.code.SaleStatus;
import io.ooruda.allclimb.module.database.entity.ticket.code.TicketType;
import org.apache.coyote.BadRequestException;

import java.math.BigDecimal;

public record TicketCreateRequest(
        TicketType ticketType,
        BigDecimal price,
        String name,
        Integer minUseGrade,
        Integer maxUseGrade,
        Integer ticketCount,
        Integer validityDay,
        SaleStatus saleStatus
) {

    private boolean invalid() {
        if (price == null || price.compareTo(BigDecimal.ZERO) < 0) return true;
        if (name == null || name.trim().isEmpty()) return true;
        if (minUseGrade == null && maxUseGrade == null) return true;
        if (ticketCount == null || ticketCount < 0) return true;
        if (validityDay == null || validityDay < 0) return true;
        if (saleStatus == null) return true;

        return switch (ticketType) {
            case COUNT -> ticketCount <= 0 && validityDay <= 0;
            case PERIOD -> validityDay <= 0;
            case null, default -> true;
        };
    }

    public TicketInfo newEntity() {

        if (invalid()) {
            throw new AllclimbException(TicketError.CREATE_ERROR);
        }

        TicketInfo ticketInfo = new TicketInfo();
        ticketInfo.setTicketType(this.ticketType);
        ticketInfo.setPrice(this.price);
        ticketInfo.setName(this.name);
        ticketInfo.setMinUseGrade(this.minUseGrade);
        ticketInfo.setMaxUseGrade(this.maxUseGrade);
        ticketInfo.setTicketCount(this.ticketType == TicketType.COUNT ? this.ticketCount : -1);
        ticketInfo.setValidityDay(this.validityDay);
        ticketInfo.setSaleStatus(this.saleStatus);
        return ticketInfo;
    }

}
