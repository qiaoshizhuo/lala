package com.cloud.ribbon.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cloud.ribbon.entity.cartItem;
import com.cloud.ribbon.repository.CartRepository;
import com.cloud.ribbon.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    @Override
    public List<cartItem> addCart(Long u_id, String cartItem) {
        //先添加再返回所以
        JSONObject jsonObject=JSON.parseObject(cartItem);
        cartItem addCartItem = JSON.toJavaObject(jsonObject, cartItem.class);
        Long p_id=addCartItem.getP_id();
        cartItem cartItem1 = cartRepository.getCartItem(p_id,u_id);
        if(cartItem1!=null)
        {
            Integer oi_num = cartItem1.getOi_num()+addCartItem.getOi_num();
            Double oi_price=oi_num*cartItem1.getP_price();
            cartRepository.updateCart(oi_num,oi_price,p_id,u_id);
        }
        else {
            cartRepository.save(addCartItem);
        }
        return cartRepository.findAll();
    }

    @Override
    public List<cartItem> deleteCart(Long u_id, Long p_id) {
        //先找看有没有
        cartItem cartItem = cartRepository.getCartItem(p_id, u_id);
        if (cartItem!=null)
        {
            cartRepository.delete(cartItem);
        }
        return cartRepository.findAll();
    }

    @Override
    public void clearAll(Long u_id) {
        cartRepository.clearAll(u_id);
    }

    @Override
    public List<cartItem> getAll(Long u_id) {

        return cartRepository.getAll(u_id);
    }
}
