package io.ooruda.allclimb.user.domain.ticket.service;

import io.ooruda.allclimb.module.database.entity.ticket.TicketInfo;
import io.ooruda.allclimb.module.database.entity.ticket.code.SaleStatus;
import io.ooruda.allclimb.module.database.repository.ticket.TicketInfoRepository;
import io.ooruda.allclimb.module.database.repository.ticket.dto.TicketInfoDefaultWhereParam;
import io.ooruda.allclimb.user.common.response.error.AllclimbException;
import io.ooruda.allclimb.user.domain.ticket.dto.Ticket;
import io.ooruda.allclimb.user.domain.ticket.error.TicketError;
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

    public List<Ticket> getList() {

        final TicketInfoDefaultWhereParam param = TicketInfoDefaultWhereParam.builder()
                .saleStatus(SaleStatus.ON_SALE)
                .build();

        List<TicketInfo> ticketInfos = ticketInfoRepository.findAllByWhere(param);
        return ticketInfos.stream().map(Ticket::of).toList();
    }

    public Ticket getOne(final long id) {
        TicketInfo ticketInfo = ticketInfoRepository.findById(id);
        return Optional.ofNullable(ticketInfo)
                .map(Ticket::of)
                .orElseThrow(() -> new AllclimbException(TicketError.NOT_FOUND_TICKET));
    }
}
