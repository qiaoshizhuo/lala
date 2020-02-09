package com.cloud.ribbon.service;

import com.cloud.ribbon.entity.cartItem;

import java.util.List;

public interface CartService {
    List<cartItem> addCart(Long u_id, String cartItem);

    List<cartItem> deleteCart(Long u_id, Long p_id);

    void clearAll(Long u_id);

    List<cartItem> getAll(Long u_id);

}
