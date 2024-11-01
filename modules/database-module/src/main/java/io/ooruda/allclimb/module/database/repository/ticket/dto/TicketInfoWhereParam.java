package io.ooruda.allclimb.module.database.repository.ticket.dto;

import io.ooruda.allclimb.module.database.entity.ticket.code.SaleStatus;
import io.ooruda.allclimb.module.database.entity.ticket.code.TicketType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TicketInfoWhereParam {

    private TicketType ticketType;
    private BigDecimal gtPrice;
    private BigDecimal ltPrice;
    private String name;
    private Integer useGrade;
    private SaleStatus saleStatus;
}
