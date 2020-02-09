package com.cloud.feign.Test;

import com.cloud.feign.service.CartService;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestCart {
    @Test
    public void addCart()
    {
        long u_id=1l;
        String product="product";
        Integer oi_num=1;
        CartService cartService = mock(CartService.class);
        when(cartService.addCart(u_id,product)).thenReturn("success");
        String success=cartService.addCart(u_id,product);
        Assert.assertSame(success,"success");
    }
    @Test
    public void deleteCart()
    {
        long u_id=1l;
        long p_id=1l;
        CartService cartService = mock(CartService.class);
        when(cartService.deleteCart(u_id,p_id)).thenReturn("success");
        String success=cartService.deleteCart(u_id,p_id);
        Assert.assertSame(success,"success");
    }
    @Test
    public void getAll()
    {
        long u_id=1l;
        CartService cartService = mock(CartService.class);
        when(cartService.getAll(u_id)).thenReturn("all");
        String all=cartService.getAll(u_id);
        Assert.assertSame(all,"all");
    }
}
