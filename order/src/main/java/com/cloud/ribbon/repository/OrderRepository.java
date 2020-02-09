package com.cloud.ribbon.repository;

import com.cloud.ribbon.entity.order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<order,Long> {
    Page<order> findAll(Specification specification, Pageable pageable);


}
