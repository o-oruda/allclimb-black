package io.ooruda.allclimb.user.domain.member.domain.entity;

import io.ooruda.allclimb.user.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Table(name = "member")
public class Member extends BaseTimeEntity {

    @Column(name = "uuid", columnDefinition = "BINARY(16)", unique = true)
    private UUID uuid;

    @Column(name = "name", nullable = false, length = 5)
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "provider", nullable = false, length = 10)
    private String provider;

    @Column(name = "provider_id", nullable = false, length = 50)
    private String providerId;

    @Column(name = "profile_image_url")
    private String profileImageUrl;

}