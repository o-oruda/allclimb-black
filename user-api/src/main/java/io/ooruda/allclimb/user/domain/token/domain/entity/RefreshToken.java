package io.ooruda.allclimb.user.domain.token.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Table(name = "refresh_token")
public class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "uuid", columnDefinition = "BINARY(16)", unique = true)
    private UUID uuid;

    @Column(name = "token", nullable = false)
    private String token;
}