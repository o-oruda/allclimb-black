package io.ooruda.allclimb.module.database.entity.pass;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Entity
@Table(name = "purchased_pass")
public class PurchasedPass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "pass_id", nullable = false)
    private Integer passId;

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

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Size(max = 50)
    @NotNull
    @ColumnDefault("'admin'")
    @Column(name = "created_by", nullable = false, length = 50)
    private String createdBy;

    @NotNull
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @Size(max = 50)
    @NotNull
    @ColumnDefault("'admin'")
    @Column(name = "updated_by", nullable = false, length = 50)
    private String updatedBy;

}