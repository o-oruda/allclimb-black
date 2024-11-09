package io.ooruda.allclimb.admin.domain.ticket.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.ooruda.allclimb.module.database.entity.ticket.TicketInfo;
import io.ooruda.allclimb.module.database.entity.ticket.code.SaleStatus;
import io.ooruda.allclimb.module.database.entity.ticket.code.TicketType;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record Ticket(
        long id,
        TicketType ticketType,
        String name,
        BigDecimal price,
        Integer minUseGrade,
        Integer maxUseGrade,
        Integer ticketCount,
        Integer validityDay,
        SaleStatus saleStatus,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime createAt,
        String createdBy,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateAt,
        String updatedBy
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
                .saleStatus(vo.getSaleStatus())
                .createAt(vo.getCreatedAt())
                .createdBy(vo.getCreatedBy())
                .updateAt(vo.getUpdatedAt())
                .updatedBy(vo.getUpdatedBy())
                .build();
    }
}
