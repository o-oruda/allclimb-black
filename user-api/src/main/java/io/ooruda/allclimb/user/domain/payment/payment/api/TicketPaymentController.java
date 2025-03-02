package io.ooruda.allclimb.user.domain.payment.payment.api;

import io.ooruda.allclimb.user.domain.payment.payment.service.TicketPaymentService;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/v1/payments/tickets")
@RestController
public class TicketPaymentController {

    private final TicketPaymentService ticketPaymentService;


    @PostMapping("/ready/{ticketId}")
    public Map<String, Object> ready(@PathVariable Long ticketId) {
        return ticketPaymentService.ready(ticketId);
    }

    @GetMapping("/success")
    public void success(@RequestParam(value = "pg_token") String token) {
        log.info("success {}", token);
    }

    @GetMapping("/fail")
    public void fail(@RequestParam(value = "pg_token") String token) {
        log.info("fail {}", token);
    }

    @GetMapping("/cancel")
    public void cancel(@RequestParam(value = "pg_token") String token) {
        log.info("cancel {}", token);
    }

}
