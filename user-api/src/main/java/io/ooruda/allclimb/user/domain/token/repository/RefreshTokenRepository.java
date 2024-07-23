package io.ooruda.allclimb.user.domain.token.repository;

import io.ooruda.allclimb.user.domain.token.domain.entity.RefreshToken;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    RefreshToken findByUuid(UUID userId);

    @Transactional
    @Modifying
    void deleteByUuid(UUID userId);

}