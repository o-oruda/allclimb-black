package io.ooruda.allclimb.module.database.repository.payment;

import io.ooruda.allclimb.module.database.entity.payment.PaymentList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentListRepository extends JpaRepository<PaymentList, Long> {

}
