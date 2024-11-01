package io.ooruda.allclimb.module.database.entity.ticket;

import io.ooruda.allclimb.module.database.entity.BaseEntity;
import io.ooruda.allclimb.module.database.entity.ticket.code.MyTicketStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Entity
@Table(name = "my_ticket")
public class MyTicket extends BaseEntity {

    /**
     * 이용권 ID
     */
    @NotNull
    @Column(name = "ticket_id", nullable = false)
    private Integer ticketId;

    /**
     * 회원 ID
     */
    @NotNull
    @Column(name = "member_id", nullable = false)
    private Integer memberId;

    /**
     * 내 이용권 상태
     */
    @Column(name = "status")
    private MyTicketStatus status;

    /**
     * 남은횟수
     */
    @NotNull
    @Column(name = "remain_count", nullable = false)
    private Integer remainCount;

    /**
     * 사용횟수
     */
    @NotNull
    @Column(name = "used_count", nullable = false)
    private Integer usedCount;

    /**
     * 사용시작일
     */
    @NotNull
    @Column(name = "start_date", nullable = false)
    private Instant startDate;

    /**
     * 만기일
     */
    @NotNull
    @Column(name = "expire_date", nullable = false)
    private Instant expireDate;

    /**
     * 결제금액
     */
    @Column(name = "payment_amount", precision = 10)
    private BigDecimal paymentAmount;

    /**
     * 할인금액
     */
    @Column(name = "discounted_amount", precision = 10)
    private BigDecimal discountedAmount;

    /**
     * 구매일자
     */
    @NotNull
    @Column(name = "purchase_at", nullable = false)
    private Instant purchaseAt;

    /**
     * 구매상태
     */
    @Size(max = 2)
    @NotNull
    @Column(name = "purchase_state", nullable = false, length = 2)
    private String purchaseState;

    /**
     * 결제정보
     */
    @Size(max = 100)
    @Column(name = "purchase_info", length = 100)
    private String purchaseInfo;

}