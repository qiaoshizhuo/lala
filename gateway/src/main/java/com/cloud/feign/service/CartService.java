package com.cloud.feign.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cloud.feign.rpc.CartRPC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    private CartRPC cartRPC;
    public String addCart(Long u_id,String cartItem)
    {

        return cartRPC.addCart(u_id,cartItem);
    }
    public String deleteCart(Long u_id,Long p_id)
    {
        return cartRPC.deleteCart(u_id,p_id);
    }
    public void clearAll(Long u_id)
    {
       cartRPC.clearAll(u_id);
    }
    public String getAll(Long u_id)
    {
        return cartRPC.getAll(u_id);
    }
}
