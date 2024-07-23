package io.ooruda.allclimb.user.domain.member.repository;

import io.ooruda.allclimb.user.domain.member.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByUuid(UUID uuid);

    Member findByProviderId(String providerId);

}
