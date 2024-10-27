package io.ooruda.allclimb.module.database.entity.ticket;

import io.ooruda.allclimb.module.database.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.Instant;

@Getter
@Entity
@Table(name = "ticket_usage_history")
public class TicketUsageHistory extends BaseEntity {

    @NotNull
    @Column(name = "gym_id", nullable = false)
    private Integer gymId;

    @NotNull
    @Column(name = "ticket_buy_id", nullable = false)
    private Integer ticketBuyId;

    @NotNull
    @Column(name = "use_dtm", nullable = false)
    private Instant useDtm;

    @Size(max = 100)
    @Column(name = "gym_name", length = 100)
    private String gymName;

}