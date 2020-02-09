package com.cloud.feign.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "cart")
public interface CartRPC {
    @RequestMapping(value = "/cart",method = RequestMethod.POST)
    String addCart(@RequestParam("u_id") Long u_id, @RequestBody String cartItem);
    @RequestMapping(value = "/cart",method = RequestMethod.DELETE)
    String deleteCart(@RequestParam("u_id") Long u_id,@RequestParam("p_id") Long p_id);
    @RequestMapping(value = "/allDelete",method = RequestMethod.DELETE)
    void clearAll(@RequestParam("u_id") Long u_id);
    @RequestMapping(value = "/all",method = RequestMethod.POST)
    String getAll(@RequestParam("u_id") Long u_id);
}
