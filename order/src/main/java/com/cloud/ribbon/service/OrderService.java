package com.cloud.ribbon.service;

import com.cloud.ribbon.entity.order;
import com.cloud.ribbon.entity.orderItem;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Page<order> getPage(Integer page, Integer size,Long u_id);

    List<orderItem> getOrderALL(Long o_id);
    orderItem addOrder(Long o_id,String product,Integer oi_num);
    order creatOrder(Long u_id);

    orderItem deleteOrder(Long o_id, Long p_id);
}
