package io.ooruda.allclimb.admin.domain.ticket.api;

import io.ooruda.allclimb.admin.domain.ticket.dto.Ticket;
import io.ooruda.allclimb.admin.domain.ticket.dto.TicketCreateRequest;
import io.ooruda.allclimb.admin.domain.ticket.dto.TicketSearchDto;
import io.ooruda.allclimb.admin.domain.ticket.service.TicketAdminService;
import io.ooruda.allclimb.module.database.entity.ticket.code.SaleStatus;
import io.ooruda.allclimb.module.database.entity.ticket.code.TicketType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Tag(name = "Ticket Admin API", description = "Ticket api for admin")
@RequiredArgsConstructor
@RequestMapping("/v1/tickets")
@RestController
public class TicketAdminController {

    private final TicketAdminService adminService;

    @Operation(summary = "Ticket list search")
    @GetMapping
    public List<Ticket> list(@RequestParam(required = false) TicketType ticketType,
                             @RequestParam(required = false) BigDecimal minPrice,
                             @RequestParam(required = false) BigDecimal maxPrice,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) Integer useGrade,
                             @RequestParam(required = false) SaleStatus saleStatus,
                             @RequestParam(required = false) String adminId) {

        return adminService.list(
                TicketSearchDto.builder()
                        .ticketType(ticketType)
                        .minPrice(minPrice)
                        .maxPrice(maxPrice)
                        .name(name)
                        .useGrade(useGrade)
                        .saleStatus(saleStatus)
                        .adminId(adminId)
                        .build());
    }

    @Operation(summary = "Ticket id search")
    @GetMapping("/{ticketId}")
    public Ticket getById(@PathVariable long ticketId) {
        return adminService.getById(ticketId);
    }

    @Operation(summary = "Created new ticket")
    @PostMapping
    public Ticket create(@RequestBody TicketCreateRequest request) {
        return adminService.create(request);
    }




}
