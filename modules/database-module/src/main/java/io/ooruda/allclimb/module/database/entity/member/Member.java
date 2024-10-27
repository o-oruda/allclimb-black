package io.ooruda.allclimb.module.database.entity.member;

import io.ooruda.allclimb.module.database.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Table(name = "member")
public class Member extends BaseEntity {

    @NotNull
    @Column(name = "uuid", columnDefinition = "BINARY(16)", unique = true)
    private UUID uuid;

    @Size(max = 50)
    @NotNull
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Size(max = 250)
    @Column(name = "email")
    private String email;

    @Size(max = 10)
    @NotNull
    @Column(name = "provider", nullable = false, length = 10)
    private String provider;

    @Size(max = 50)
    @NotNull
    @Column(name = "provider_id", nullable = false, length = 50)
    private String providerId;

    @Column(name = "profile_image_url")
    private String profileImageUrl;

}