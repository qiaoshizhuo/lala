package com.cloud.ribbon.repository;

import com.cloud.ribbon.entity.cartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Transactional
public interface CartRepository extends JpaRepository<cartItem,Long> {
    @Query(value = "select * from t_cart_item where u_id=:u_id",nativeQuery = true)
    List<cartItem> getAll(@RequestParam("u_id") Long u_id);
    @Query(value = "select * from t_cart_item where p_id=:p_id and u_id=:u_id",nativeQuery = true)
     cartItem getCartItem(@RequestParam("p_id") Long p_id,@RequestParam("u_id") Long u_id);
    @Modifying
    @Query(value = "update t_cart_item set oi_num=:oi_num,oi_price=:oi_price where p_id=:p_id and u_id=:u_id", nativeQuery = true)
    void updateCart(@RequestParam("oi_num") Integer oi_num,@RequestParam("oi_price") Double oi_price,@RequestParam("p_id") Long p_id,@RequestParam("u_id") Long u_id);
    @Modifying
    @Query(value = "delete from t_cart_item where u_id=:u_id",nativeQuery = true)
    void clearAll(@RequestParam("u_id") Long u_id);
}
