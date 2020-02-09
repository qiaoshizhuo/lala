package com.cloud.ribbon.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cloud.ribbon.entity.order;
import com.cloud.ribbon.entity.orderItem;
import com.cloud.ribbon.repository.OrderItemRepository;
import com.cloud.ribbon.repository.OrderRepository;
import com.cloud.ribbon.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Override
    public Page<order> getPage(Integer page, Integer size,Long u_id) {
        Pageable pageable =new PageRequest(page - 1,size);
        return orderRepository.findAll(new Specification<Long>() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list=new ArrayList<Predicate>();
                if(u_id!=null)
                {
                    list.add(criteriaBuilder.equal(root.get("u_id").as(Long.class), u_id));
                }
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));
            }
        },pageable);
    }

    @Override
    public List<orderItem> getOrderALL(Long o_id) {
        Optional<order> order=orderRepository.findById(o_id);
        System.out.println(order);
        System.out.println(order.get().getOrderItems());
        return new ArrayList<orderItem>(order.get().getOrderItems());
    }

    @Override
    public orderItem addOrder(Long o_id,String product,Integer oi_num) {

        //将这个商品加入订单
        //解析product
        JSONObject jsonObject= JSON.parseObject(product);
        Long p_id = jsonObject.getLong("p_id");
        Double p_price = jsonObject.getDouble("p_price");
        Optional<order> order = orderRepository.findById(o_id);
        orderItem orderItem=new orderItem();
        orderItem.setOi_num(oi_num);
        orderItem.setP_id(p_id);
        orderItem.setOrder(order.get());
        Double oi_price=oi_num*p_price;
        orderItem.setOi_price(oi_price);
        Double o_price=orderItem.getOrder().getO_price()+oi_price;
        orderItem.getOrder().setO_price(o_price);
        return orderItemRepository.save(orderItem);

    }


    @Override
    public order creatOrder(Long u_id) {
        order order=new order();
        order.setU_id(u_id);
        order.setO_price(0.0);
        return orderRepository.save(order);

    }
    //给订单上删除一个商品
    @Override
    public orderItem deleteOrder(Long o_id, Long p_id) {
        Optional<order> order = orderRepository.findById(o_id);
        //根据o_id和p_id查找oi

       orderItem orderItem= orderItemRepository.getOrderItem(o_id,p_id);
       //再删除
        if (orderItem!=null) {
            Double o_price = order.get().getO_price();
            order.get().setO_price(o_price-orderItem.getOi_price());
            orderItemRepository.delete(orderItem);
        }
        return orderItem;
    }
}
