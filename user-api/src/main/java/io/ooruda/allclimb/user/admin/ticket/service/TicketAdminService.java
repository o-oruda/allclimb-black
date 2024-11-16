package io.ooruda.allclimb.user.admin.ticket.service;

import io.ooruda.allclimb.module.database.entity.ticket.TicketInfo;
import io.ooruda.allclimb.user.admin.ticket.dto.Ticket;
import io.ooruda.allclimb.user.admin.ticket.dto.TicketCreateRequest;
import io.ooruda.allclimb.user.admin.ticket.dto.TicketModifyRequest;
import io.ooruda.allclimb.user.admin.ticket.dto.TicketSearchDto;
import io.ooruda.allclimb.user.admin.ticket.error.TicketError;
import io.ooruda.allclimb.user.admin.ticket.repository.TicketInfoInfoAdminRepository;
import io.ooruda.allclimb.user.admin.ticket.repository.dto.TicketInfoAdminWhereParam;
import io.ooruda.allclimb.user.admin.ticket.repository.dto.TicketInfoUpdateSet;
import io.ooruda.allclimb.user.common.response.error.AllclimbException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TicketAdminService {

    private final TicketInfoInfoAdminRepository ticketInfoAdminRepository;

    public List<Ticket> list(final TicketSearchDto searchDto) {

        final TicketInfoAdminWhereParam where = TicketInfoAdminWhereParam.of(searchDto);
        return ticketInfoAdminRepository.findAllSelect(where)
                .stream()
                .map(Ticket::of).toList();
    }

    public Ticket getById(final long ticketId) {
        return Optional.ofNullable(ticketInfoAdminRepository.findById(ticketId))
                .map(Ticket::of)
                .orElseThrow(() -> new AllclimbException(TicketError.NOT_FOUND_TICKET));
    }

    @Transactional
    public Ticket create(final TicketCreateRequest request) {

        TicketInfo ticketInfo = request.newEntity();
        long newTicketId = ticketInfoAdminRepository.create(ticketInfo);
        return Optional.ofNullable(ticketInfoAdminRepository.findById(newTicketId))
                .map(Ticket::of)
                .orElseThrow(() -> new AllclimbException(TicketError.CREATE_ERROR));
    }

    @Transactional
    public Ticket modify(final long ticketId, final TicketModifyRequest request) {

        long updateCount = ticketInfoAdminRepository.update(ticketId, TicketInfoUpdateSet.of(request));
        if (updateCount == 0) {
            throw new AllclimbException(TicketError.UPDATE_ERROR);
        }

        TicketInfo ticketInfo = Optional.ofNullable(ticketInfoAdminRepository.findById(ticketId))
                .orElseThrow(() -> new AllclimbException(TicketError.UPDATE_ERROR));
        if (ticketInfo.invalidTicket()) {
            throw new AllclimbException(TicketError.UPDATE_ERROR);
        }
        return Ticket.of(ticketInfo);
    }

    @Transactional
    public void delete(final long ticketId) {
        long deleteCount = ticketInfoAdminRepository.delete(ticketId);
        if (deleteCount == 0) {
            throw new AllclimbException(TicketError.DELETE_ERROR);
        }
    }

}
