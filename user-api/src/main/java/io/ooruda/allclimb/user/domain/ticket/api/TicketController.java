package io.ooruda.allclimb.user.domain.ticket.api;

import io.ooruda.allclimb.module.database.entity.ticket.code.TicketType;
import io.ooruda.allclimb.user.domain.ticket.api.request.TicketSearchDto;
import io.ooruda.allclimb.user.domain.ticket.api.response.Ticket;
import io.ooruda.allclimb.user.domain.ticket.service.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/v1/tickets")
@RestController
public class TicketController {

    private final TicketService ticketService;

    @GetMapping
    public List<Ticket> list(
            @RequestParam (required = false) Optional<String> ticketTypeCode) {

        return ticketService.getList(
                TicketSearchDto.builder()
                        .ticketType(ticketTypeCode.map(TicketType::fromCode).orElse(null))
                        .build());
    }

    @GetMapping("/{ticketId}")
    public Ticket getById(@PathVariable long ticketId) {
        return ticketService.getOne(ticketId);
    }

}
