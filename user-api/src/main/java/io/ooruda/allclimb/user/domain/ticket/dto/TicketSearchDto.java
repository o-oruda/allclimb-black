package io.ooruda.allclimb.user.domain.ticket.dto;

import io.ooruda.allclimb.module.database.entity.ticket.code.TicketType;
import lombok.Builder;

@Builder
public record TicketSearchDto(
        TicketType ticketType
) {
}
