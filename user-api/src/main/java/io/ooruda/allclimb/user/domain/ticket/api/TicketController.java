package io.ooruda.allclimb.user.domain.ticket.api;

import io.ooruda.allclimb.user.domain.ticket.dto.Ticket;
import io.ooruda.allclimb.user.domain.ticket.service.TicketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Tag(name = "Ticket", description = "Ticket api for front")
@RequiredArgsConstructor
@RequestMapping("/v1/tickets")
@RestController
public class TicketController {

    private final TicketService ticketService;

    @Operation(summary = "Ticket 목록 조회")
    @GetMapping
    public List<Ticket> list() {
        return ticketService.getList();
    }

    @Operation(summary = "Ticket id 조회")
    @GetMapping("/{ticketId}")
    public Ticket getById(@PathVariable long ticketId) {
        return ticketService.getOne(ticketId);
    }

}
