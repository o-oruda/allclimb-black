package io.ooruda.allclimb.module.database.repository;

import io.ooruda.allclimb.module.database.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByUuid(UUID uuid);

    Member findByProviderId(String providerId);

}
