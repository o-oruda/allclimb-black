package io.ooruda.allclimb.module.database.entity.ticket;

import io.ooruda.allclimb.module.database.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Entity
@Table(name = "ticket_info")
public class TicketInfo extends BaseEntity {

    @Size(max = 2)
    @NotNull
    @Column(name = "ticket_type", nullable = false, length = 2)
    private String ticketType;

    @NotNull
    @Column(name = "price", nullable = false, precision = 10)
    private BigDecimal price;

    @Size(max = 100)
    @NotNull
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "min_use_grade")
    private Integer minUseGrade;

    @Column(name = "max_use_grade")
    private Integer maxUseGrade;

    @Column(name = "ticket_count")
    private Integer ticketCount;

    @Column(name = "validity_day")
    private Integer validityDay;

    @Size(max = 2)
    @Column(name = "sale_status", length = 2)
    private String saleStatus;

}