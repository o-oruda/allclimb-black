package io.ooruda.allclimb.user.domain.ticket;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Tag(name = "Ticket", description = "Ticket api for front")
@RequiredArgsConstructor
@RequestMapping("/v1/tickets")
@RestController
public class TicketController {

    @Operation(summary = "Ticket 목록 조회")
    @GetMapping
    public String list() {
        log.info("ticketList");
        return "tickets";
    }
}
