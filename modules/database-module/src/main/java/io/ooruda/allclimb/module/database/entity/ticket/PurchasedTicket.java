package io.ooruda.allclimb.module.database.entity.ticket;

import io.ooruda.allclimb.module.database.entity.BaseEntity;
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
@Table(name = "purchased_ticket")
public class PurchasedTicket extends BaseEntity {

    @NotNull
    @Column(name = "ticket_id", nullable = false)
    private Integer ticketId;

    @NotNull
    @Column(name = "member_id", nullable = false)
    private Integer memberId;

    @Column(name = "payment_amount", precision = 10)
    private BigDecimal paymentAmount;

    @Column(name = "discounted_amount", precision = 10)
    private BigDecimal discountedAmount;

    @NotNull
    @Column(name = "remain_count", nullable = false)
    private Integer remainCount;

    @NotNull
    @Column(name = "used_count", nullable = false)
    private Integer usedCount;

    @NotNull
    @Column(name = "start_date", nullable = false)
    private Instant startDate;

    @NotNull
    @Column(name = "expire_date", nullable = false)
    private Instant expireDate;

    @NotNull
    @Column(name = "purchase_at", nullable = false)
    private Instant purchaseAt;

    @Size(max = 2)
    @NotNull
    @Column(name = "purchase_state", nullable = false, length = 2)
    private String purchaseState;

    @Size(max = 100)
    @Column(name = "purchase_info", length = 100)
    private String purchaseInfo;

}