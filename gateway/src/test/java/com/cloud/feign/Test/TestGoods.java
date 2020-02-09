package com.cloud.feign.Test;

import com.cloud.feign.service.GoodsService;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestGoods {
    @Test
    public void getAll(){
        Integer page=1;
        Integer size=4;
        GoodsService goodsService = mock(GoodsService.class);
        when(goodsService.getAll(page,size)).thenReturn("goods");
        String goods=goodsService.getAll(page,size);
        Assert.assertSame(goods,"goods");
    }
    @Test
    public void getProduct()
    {
        long p_id=1l;
        GoodsService goodsService = mock(GoodsService.class);
        when(goodsService.getProduct(p_id)).thenReturn("product");
        String product=goodsService.getProduct(p_id);
        Assert.assertSame(product,"product");
    }
    @Test
    public void getGood()
    {
        long p_id=1l;
        GoodsService goodsService = mock(GoodsService.class);
        when(goodsService.getGood(p_id)).thenReturn("good");
        String good=goodsService.getGood(p_id);
        Assert.assertSame(good,"good");
    }
}
