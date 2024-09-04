package io.ooruda.allclimb.module.database.entity.pass;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Entity
@Table(name = "pass_usage_history")
public class PassUsageHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "gym_id", nullable = false)
    private Integer gymId;

    @NotNull
    @Column(name = "pass_buy_id", nullable = false)
    private Integer passBuyId;

    @NotNull
    @Column(name = "use_dtm", nullable = false)
    private Instant useDtm;

    @Size(max = 100)
    @Column(name = "gym_name", length = 100)
    private String gymName;

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