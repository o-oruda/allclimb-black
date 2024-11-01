package io.ooruda.allclimb.module.database.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @CreatedDate
    @ColumnDefault("CURRENT_TIMESTAMP")
    @NotNull
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @ColumnDefault("'system'")
    @NotNull
    @Size(max = 50)
    @Column(name = "created_by", nullable = false, updatable = false, length = 50)
    private String createdBy;

    @LastModifiedDate
    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @ColumnDefault("'admin'")
    @NotNull
    @Size(max = 50)
    @Column(name = "updated_by", nullable = false, length = 50)
    private String updatedBy;
}