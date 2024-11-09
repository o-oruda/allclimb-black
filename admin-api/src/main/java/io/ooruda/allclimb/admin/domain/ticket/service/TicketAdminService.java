package io.ooruda.allclimb.admin.domain.ticket.service;

import io.ooruda.allclimb.admin.common.response.error.AllclimbException;
import io.ooruda.allclimb.admin.domain.ticket.dto.Ticket;
import io.ooruda.allclimb.admin.domain.ticket.dto.TicketCreateRequest;
import io.ooruda.allclimb.admin.domain.ticket.dto.TicketSearchDto;
import io.ooruda.allclimb.admin.domain.ticket.error.TicketError;
import io.ooruda.allclimb.admin.domain.ticket.repository.TicketInfoAdminRepository;
import io.ooruda.allclimb.admin.domain.ticket.repository.dto.TicketInfoAdminWhere;
import io.ooruda.allclimb.module.database.entity.ticket.TicketInfo;
import io.ooruda.allclimb.module.database.repository.ticket.TicketInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TicketAdminService {

    private final TicketInfoAdminRepository ticketInfoAdminRepository;

    public List<Ticket> list(final TicketSearchDto searchDto) {

        TicketInfoAdminWhere where = TicketInfoAdminWhere.builder()
                .ticketType(searchDto.ticketType())
                .maxLimitPrice(searchDto.maxPrice())
                .minLimitPrice(searchDto.minPrice())
                .name(searchDto.name())
                .useGrade(searchDto.useGrade())
                .saleStatus(searchDto.saleStatus())
                .adminId(searchDto.adminId())
                .build();
        return ticketInfoAdminRepository.findAllSelect(where)
                .stream()
                .map(Ticket::of).toList();
    }

    public Ticket getById(final long ticketId) {
        return ticketInfoAdminRepository.findById(ticketId)
                .map(Ticket::of)
                .orElseThrow(() -> new AllclimbException(TicketError.NOT_FOUND_TICKET));
    }

    public Ticket create(final TicketCreateRequest request) {

        TicketInfo ticketInfo = request.newEntity();
        ticketInfoAdminRepository.create(ticketInfo);
        return Ticket.of(ticketInfo);
    }

}
