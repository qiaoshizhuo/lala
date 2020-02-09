package com.cloud.feign.service;

import com.cloud.feign.rpc.OrderRPC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRPC orderRPC;
    public String getALL(Integer page,Integer size,Long u_id)
    {
        return orderRPC.getAll(page,size,u_id);
    }
    public String getOrder(Long o_id)
    {
        return orderRPC.getOrder(o_id);
    }
    public String creatOrder(Long u_id)
    {
        return orderRPC.creatOrder(u_id);
    }
    public String getOrderPost(Long o_id,Integer oi_num,String product)
    {
        return orderRPC.getOrderPost(o_id,oi_num,product);
    }
    public String deleteOrder(Long o_id,Long p_id)
    {
        return orderRPC.deleteOrder(o_id,p_id);
    }
}
