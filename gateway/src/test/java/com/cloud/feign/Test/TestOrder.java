package com.cloud.feign.Test;

import com.cloud.feign.service.OrderService;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestOrder {
    @Test
    public void getALL()
    {
        long u_id=1l;
        Integer page=1;
        Integer size=4;
        OrderService orderService = mock(OrderService.class);
        when(orderService.getALL(page,size,u_id)).thenReturn("all");
       String all= orderService.getALL(page,size,u_id);
        Assert.assertSame(all,"all");
    }
    @Test
    public void getOrder()
    {
        long o_id=1l;
        OrderService orderService = mock(OrderService.class);
        when(orderService.getOrder(o_id)).thenReturn("order");
        String order= orderService.getOrder(o_id);
        Assert.assertSame(order,"order");

    }
    @Test
    public void creatOrder()
    {
        long o_id=1l;
        OrderService orderService = mock(OrderService.class);
        when(orderService.creatOrder(o_id)).thenReturn("order");
        String order= orderService.creatOrder(o_id);
        Assert.assertSame(order,"order");
    }
    @Test
    public void getOrderPost()
    {
        long o_id=1l;
        Integer oi_num=3;
        String product="product";
        OrderService orderService = mock(OrderService.class);
        when(orderService.getOrderPost(o_id,oi_num,product)).thenReturn("orderPost");
        String orderPost= orderService.getOrderPost(o_id,oi_num,product);
        Assert.assertSame(orderPost,"orderPost");
    }
    @Test
    public void deleteOrder()
    {
        long o_id=1l;
        long p_id=1l;
        OrderService orderService = mock(OrderService.class);
        when(orderService.deleteOrder(o_id,p_id)).thenReturn("order");
        String order= orderService.deleteOrder(o_id,p_id);
        Assert.assertSame(order,"order");
    }
}
