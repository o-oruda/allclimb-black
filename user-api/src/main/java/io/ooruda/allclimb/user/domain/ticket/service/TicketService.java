package io.ooruda.allclimb.user.domain.ticket.service;

import io.ooruda.allclimb.user.common.response.error.AllclimbException;
import io.ooruda.allclimb.user.domain.ticket.dto.TicketSearchDto;
import io.ooruda.allclimb.user.domain.ticket.dto.Ticket;
import io.ooruda.allclimb.user.domain.ticket.error.TicketError;
import io.ooruda.allclimb.user.domain.ticket.repository.TicketInfoRepository;
import io.ooruda.allclimb.user.domain.ticket.repository.dto.TicketInfoWhereDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class TicketService {

    private final TicketInfoRepository ticketInfoRepository;

    public List<Ticket> getList(final TicketSearchDto searchParam) {

        return ticketInfoRepository.findAllSelect(TicketInfoWhereDto.of(searchParam))
                .stream().map(Ticket::of).toList();
    }

    public Ticket getOne(final long id) {
        return Optional.ofNullable(ticketInfoRepository.findById(id))
                .map(Ticket::of)
                .orElseThrow(() -> new AllclimbException(TicketError.NOT_FOUND_TICKET));
    }
}
