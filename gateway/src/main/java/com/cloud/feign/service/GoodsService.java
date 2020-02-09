package com.cloud.feign.service;

import com.cloud.feign.rpc.GoodsRPC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class GoodsService {
    @Autowired
    private GoodsRPC goodsRPC; //注入rpc

    public String getAll(Integer page,Integer size){
        return goodsRPC.getAll(page,size);
    }
    public String getProduct(Long p_id)
    {
        return goodsRPC.getProduct(p_id);
    }
    public String getGood(Long p_id)
    {
        return goodsRPC.getGood(p_id);
    }

}
