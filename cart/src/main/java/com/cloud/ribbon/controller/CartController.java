package com.cloud.ribbon.controller;

import com.cloud.ribbon.entity.cartItem;
import com.cloud.ribbon.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {
    @Autowired
    private CartService cartService;
    @RequestMapping(value = "/cart",method = RequestMethod.POST)
    public List<cartItem> addCart(@RequestParam("u_id") Long u_id, @RequestBody String cartItem)
    {
        return cartService.addCart(u_id,cartItem);
    }
    @RequestMapping(value = "/cart",method = RequestMethod.DELETE)
    public List<cartItem> deleteCart(@RequestParam("u_id") Long u_id,@RequestParam("p_id") Long p_id)
    {
        return cartService.deleteCart(u_id,p_id);
    }
    @RequestMapping(value = "/allDelete",method = RequestMethod.DELETE)
    public void clearAll(@RequestParam("u_id") Long u_id)
    {
        cartService.clearAll(u_id);
    }
    @RequestMapping(value = "/all",method = RequestMethod.POST)
    public List<cartItem> all(@RequestParam("u_id") Long u_id)
    {
        return cartService.getAll(u_id);

    }
}
