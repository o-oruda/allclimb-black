package io.ooruda.allclimb.user.admin.ticket.api;

import io.ooruda.allclimb.module.database.entity.ticket.code.SaleStatus;
import io.ooruda.allclimb.module.database.entity.ticket.code.TicketType;
import io.ooruda.allclimb.user.admin.ticket.dto.Ticket;
import io.ooruda.allclimb.user.admin.ticket.dto.TicketCreateRequest;
import io.ooruda.allclimb.user.admin.ticket.dto.TicketModifyRequest;
import io.ooruda.allclimb.user.admin.ticket.dto.TicketSearchDto;
import io.ooruda.allclimb.user.admin.ticket.service.TicketAdminService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/admin/v1/tickets")
@RestController
public class TicketAdminController {

    private final TicketAdminService adminService;

    @GetMapping
    public List<Ticket> list(@RequestParam(required = false) Optional<String> ticketTypeCode,
                             @RequestParam(required = false) BigDecimal minPrice,
                             @RequestParam(required = false) BigDecimal maxPrice,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) Integer useGrade,
                             @RequestParam(required = false) Optional<String> saleStatusCode,
                             @RequestParam(required = false) String adminId) {

        return adminService.list(
                TicketSearchDto.builder()
                        .ticketType(ticketTypeCode.map(TicketType::fromCode).orElse(null))
                        .minPrice(minPrice)
                        .maxPrice(maxPrice)
                        .name(name)
                        .useGrade(useGrade)
                        .saleStatus(saleStatusCode.map(SaleStatus::fromCode).orElse(null))
                        .adminId(adminId)
                        .build());
    }

    @GetMapping("/{ticketId}")
    public Ticket getById(@PathVariable long ticketId) {
        return adminService.getById(ticketId);
    }

    @PostMapping
    public Ticket create(@RequestBody TicketCreateRequest request) {
        return adminService.create(request);
    }

    @PatchMapping("/{ticketId}")
    public Ticket update(@PathVariable long ticketId, @RequestBody TicketModifyRequest request) {
        return adminService.modify(ticketId, request);
    }

    @DeleteMapping("/{ticketId}")
    public void delete(@PathVariable long ticketId) {
        adminService.delete(ticketId);
    }
}
