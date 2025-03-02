package io.ooruda.allclimb.user.domain.payment.payment.service;

import io.ooruda.allclimb.module.database.entity.payment.PaymentList;
import io.ooruda.allclimb.module.database.entity.ticket.TicketInfo;
import io.ooruda.allclimb.module.database.repository.payment.PaymentListRepository;
import io.ooruda.allclimb.user.common.response.error.AllclimbException;
import io.ooruda.allclimb.user.domain.payment.kakao.KakaoPaymentService;
import io.ooruda.allclimb.user.domain.payment.payment.error.TicketPaymentError;
import io.ooruda.allclimb.user.domain.ticket.repository.TicketInfoRepository;
import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class TicketPaymentService {

    private final KakaoPaymentService kakaoPaymentService;
    private final TicketInfoRepository ticketInfoRepository;
    private final PaymentListRepository paymentListRepository;

    public Map<String, Object> ready(Long ticketId) {

        TicketInfo ticketInfo = Optional.ofNullable(ticketInfoRepository.findById(ticketId))
                .orElseThrow(() -> new AllclimbException(TicketPaymentError.NOT_FOUND_TICKET));
        if (ticketInfo.invalidTicket()) {
            throw new AllclimbException(TicketPaymentError.NOT_FOUND_TICKET);
        }

        PaymentList paymentList = paymentListRepository.save(PaymentList.from(1, ticketInfo));
        log.info("payment ready request {}", paymentList);
        // TODO save log
        return kakaoPaymentService.ready(paymentList);
    }


}
