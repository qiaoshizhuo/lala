package com.cloud.feign.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "order")
public interface OrderRPC {
    @RequestMapping(value = "/orders",method = RequestMethod.GET)
    String getAll(@RequestParam(value = "page") Integer page, @RequestParam(value = "size") Integer size,@RequestParam("u_id") Long u_id);
    @RequestMapping(value = "/order/{id}",method = RequestMethod.GET)
    String getOrder(@PathVariable("id") Long o_id);
    @RequestMapping(value = "/order",method = RequestMethod.POST)
    String creatOrder(@RequestParam("u_id") Long u_id);
    @RequestMapping(value = "/order/{id}",method = RequestMethod.POST)
    String getOrderPost(@PathVariable("id") Long o_id,  @RequestParam(value = "oi_num",defaultValue = "3") Integer oi_num,@RequestBody String product);
    @RequestMapping(value = "/order/{id}",method = RequestMethod.DELETE)
    String deleteOrder(@PathVariable("id") Long o_id, @RequestBody Long p_id);
}
