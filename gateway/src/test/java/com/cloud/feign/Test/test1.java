package com.cloud.feign.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cloud.feign.service.CartService;
import com.cloud.feign.service.GoodsService;
import com.cloud.feign.service.OrderService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class test1 {

    @Test
    public void getCart() {
        long u_id=1l;
        CartService cartService = mock(CartService.class);
        when(cartService.getAll(u_id)).thenReturn("all");
        String all=cartService.getAll(u_id);
        Assert.assertSame(all,"all");
    }
    @Test
    public void getALLProduct(){
        Integer page=1;
        Integer size=4;
        GoodsService goodsService = mock(GoodsService.class);
        when(goodsService.getAll(page,size)).thenReturn("page");
        String all=goodsService.getAll(page,size);
        Assert.assertSame(all,"page");
    }
    @Test
    public void getProduct(){
        long p_id=1l;
        GoodsService goodsService = mock(GoodsService.class);
        when(goodsService.getProduct(p_id)).thenReturn("product");
        String product = goodsService.getProduct(p_id);
        Assert.assertSame(product,"product");
    }
    @Test
    public void getALLOrder()
    {
        Integer page=1;
        Integer size=4;
        long u_id=1l;
        OrderService orderService = mock(OrderService.class);
        when(orderService.getALL(page,size,u_id)).thenReturn("orders");
        String orders=orderService.getALL(page,size,u_id);
        Assert.assertSame(orders,"orders");
    }


}
