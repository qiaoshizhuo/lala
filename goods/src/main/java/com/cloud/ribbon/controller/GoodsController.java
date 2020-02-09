package com.cloud.ribbon.controller;

import com.cloud.ribbon.entity.product;
import com.cloud.ribbon.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@RestController
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @RequestMapping(value = "/goods",method = RequestMethod.GET)
    public Page<product> getAll(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "size", defaultValue = "4") Integer size)
    {

        return goodsService.getPage(page,size);
    }
    @RequestMapping(value = "/goods/{id}",method = RequestMethod.GET)
    public Optional<product> getGoods(@PathVariable("id") Long p_id)
    {
        return goodsService.getGoods(p_id);
    }
    @RequestMapping(value = "/good/{id}")
    public Optional<product> getGood(@PathVariable("id") Long p_id)
    {
        return goodsService.getGoods(p_id);
    }
}
