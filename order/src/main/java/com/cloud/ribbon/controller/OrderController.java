package com.cloud.ribbon.controller;

import com.cloud.ribbon.entity.order;
import com.cloud.ribbon.entity.orderItem;
import com.cloud.ribbon.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @RequestMapping(value = "/orders",method = RequestMethod.GET)
    public Page<order> getAll(@RequestParam("u_id") Long u_id,@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "4") Integer size)
    {
        return orderService.getPage(page,size,u_id);
    }
    @RequestMapping(value = "/order/{id}",method = RequestMethod.GET)
    public List<orderItem> getOrder(@PathVariable("id") Long o_id)
    {
        return orderService.getOrderALL(o_id);
    }
    @RequestMapping(value = "/order",method = RequestMethod.POST)
    public order creatOrder(@RequestParam("u_id") Long u_id)
    {
        return orderService.creatOrder(u_id);
    }
    //给订单加上一个商品
    @RequestMapping(value = "/order/{id}",method = RequestMethod.POST)
    public orderItem addOrder(@PathVariable("id") Long o_id,  @RequestParam(value = "oi_num",defaultValue = "3") Integer oi_num,@RequestBody String product)
    {
       return orderService.addOrder(o_id,product,oi_num);
    }
    //给订单上删除一个商品
    @RequestMapping(value = "/order/{id}",method = RequestMethod.DELETE)
    public orderItem deleteOrder(@PathVariable("id") Long o_id, @RequestBody Long p_id)
    {
        return orderService.deleteOrder(o_id,p_id);
    }




}
