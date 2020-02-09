package com.cloud.ribbon.repository;

import com.cloud.ribbon.entity.billing;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public interface BillingRepository extends JpaRepository<billing,Long> {
    @Query(value = "select * from t_billing where o_id=:o_id",nativeQuery = true)
    billing getBilling(@RequestParam("o_id") Long o_id);

}
