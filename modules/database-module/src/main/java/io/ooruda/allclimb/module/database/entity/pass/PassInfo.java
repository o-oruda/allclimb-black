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
@Table(name = "pass_info")
public class PassInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 2)
    @NotNull
    @Column(name = "pass_type", nullable = false, length = 2)
    private String passType;

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

    @Column(name = "pass_count")
    private Integer passCount;

    @Column(name = "validity_day")
    private Integer validityDay;

    @Size(max = 2)
    @Column(name = "sale_status", length = 2)
    private String saleStatus;

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
    @ColumnDefault(" ,'admin'")
    @Column(name = "updated_by", nullable = false, length = 50)
    private String updatedBy;

}