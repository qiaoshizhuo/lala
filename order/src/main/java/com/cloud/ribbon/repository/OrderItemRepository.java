package com.cloud.ribbon.repository;

import com.cloud.ribbon.entity.orderItem;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

public interface OrderItemRepository extends JpaRepository<orderItem,Long> {

    orderItem findAll(Specification<Long> longSpecification);
    @Query(value = "select * from t_order_item where o_id=:o_id and p_id=:p_id",nativeQuery = true)
    orderItem getOrderItem(@RequestParam("o_id") Long o_id,@RequestParam("p_id") Long p_id);
}
