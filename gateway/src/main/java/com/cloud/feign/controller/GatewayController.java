package com.cloud.feign.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cloud.feign.service.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class GatewayController {
    final static Logger logger = Logger.getLogger(GatewayController.class);
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private BillingService billingService;
    @Autowired
    private CartService cartService;
    @GetMapping("/goods")
    public String getALLProduct(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "4") Integer size){
        logger.info("HELLO goods");
        return goodsService.getAll(page,size);
    }
    @GetMapping("/goods/{id}")
    public String getProduct(@PathVariable("id") Long p_id){
        logger.info("HELLO goods in id");
        return goodsService.getProduct(p_id);
    }
    //GET /user/{userId}/orders
    @GetMapping("/user/{userId}/orders")
    public String get2Order(@PathVariable("userId")Long u_id,@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "4") Integer size)
    {
        logger.info("HELLO orders");
        String orders=orderService.getALL(page,size,u_id);
        // return orderService.getALL(page,size,u_id);
        return orders;

    }
    //GET /user/{userId}/order/{id}
    @GetMapping("/user/{userId}/order/{id}")
    public String getOrder(@PathVariable("userId") Long u_id,@PathVariable("id") Long o_id)
    {
        logger.info("HELLO orders in userId");
        //获取到了product的p_id，但是要根据p_id获取到product的详细信息
        String orderItems=orderService.getOrder(o_id);
        //可以有效的读取json数组
        JSONArray jsonArray=JSONArray.parseArray(orderItems);
        //迭代数组--
        List<JSONObject> itemList=new ArrayList<JSONObject>();
        for (Iterator iterator = jsonArray.iterator(); iterator.hasNext();) {
            JSONObject job=(JSONObject)iterator.next();
            Long p_id = job.getLong("p_id");
            String product=goodsService.getProduct(p_id);
            JSONObject jsonObject= JSON.parseObject(product);
            job.put("p_name",jsonObject.get("p_name"));
            job.put("p_price",jsonObject.getDouble("p_price"));
            itemList.add(job);
        }
        return itemList.toString();
    }
    //POST /user/{userId}/order - создать заказ.
    @PostMapping("/user/{userId}/order")
    public String getALLOrder(@PathVariable("userId") Long u_id)
    {
        logger.info("HELLO all orders");
        //在新建order的时候需要将cart中的所有加入这个订单
        String order=orderService.creatOrder(u_id);
        JSONObject jsonOrder=JSON.parseObject(order);
        String cart = cartService.getAll(u_id);
        //解析cart--获取到cart的这个人的数据，并删除
        JSONArray cartArray=JSONArray.parseArray(cart);
        //删除数据库cart中的这个人的数据
        cartService.clearAll(u_id);
        //迭代cartArray
        for(Iterator iterator=cartArray.iterator();iterator.hasNext();)
        {
            //这个等于一个orderItem
            JSONObject cartItem = (JSONObject) iterator.next();
            String product=goodsService.getGood(cartItem.getLong("p_id"));
            orderService.getOrderPost(jsonOrder.getLong("o_id"),jsonOrder.getInteger("oi_num"),product);
        }

        //将这个订单加入billing
        String billing=billingService.addBilling(jsonOrder.getLong("o_id"));
        //order需要重新获取--也可以重定向到/orders让重新获取
        return order;
    }
    //POST /user/{userId}/order/{orderId}/good/{goodId} - добавить товар в заказ.
    //记录一下，要先判断人存在不，再判断商品存在不，再进行操作
    @PostMapping("/user/{userId}/order/{orderId}/good/{goodId}")
    public String addProduct2Order(@RequestParam(value = "oi_num",defaultValue = "3") Integer oi_num,@PathVariable("userId") Long u_id,@PathVariable("orderId") Long o_id,@PathVariable("goodId") Long p_id)
    {
        String product=goodsService.getGood(p_id);
        return orderService.getOrderPost(o_id,oi_num,product);
    }
    //DELETE /user/{userId}/order/{orederId}/good/{goodId} - удалить товар из заказа.
    //记录一下，要先判断人存在不，再判断商品,再判断orderItem在不在，然后操作
    @DeleteMapping("/user/{userId}/order/{orderId}/good/{goodId}")
    public String deleteGood(@PathVariable("userId") Long u_id,@PathVariable("orderId") Long o_id,@PathVariable("goodId") Long p_id)
    {
        logger.info("HELLO delete goods in order");
        return orderService.deleteOrder(o_id,p_id);
    }
    //POST /user/{userId}/order/{id}/billing
    @PostMapping("/user/{userId}/order/{id}/billing")
    public String setBilling(@PathVariable("userId") Long u_id,@PathVariable("id") Long o_id)
    {
        logger.info("HELLO setBilling");
        String billing=billingService.setBilling(o_id);
        return billing;
    }
    //POST /user/{userId}/goods/{goodID}/cart
    @PostMapping(value = "/user/{userId}/goods/{goodId}/cart")
    public String addCart(@PathVariable("userId") Long u_id, @PathVariable("goodId") Long p_id, @RequestParam("oi_num") Integer oi_num, HttpServletResponse response) throws IOException {
        logger.info("HELLO add goods");
        String product=goodsService.getGood(p_id);
        //把product变为cartItem
        JSONObject jsonObject= JSON.parseObject(product);
        jsonObject.put("oi_num",oi_num);
        jsonObject.put("u_id",u_id);
        Double p_price = jsonObject.getDouble("p_price");
        jsonObject.put("oi_price",p_price*oi_num);
        String cartItem=jsonObject.toJSONString();
        cartService.addCart(u_id,cartItem);
        response.getWriter().write("{\"flag\":\"success\"}");
        return null;
    }
    @DeleteMapping(value = "/user/{userId}/goods/{goodId}/cart")
    public String deleteCart(@PathVariable("userId") Long u_id,@PathVariable("goodId") Long p_id)
    {
        logger.info("HELLO deleteCart");
        return cartService.deleteCart(u_id,p_id);
    }
}
