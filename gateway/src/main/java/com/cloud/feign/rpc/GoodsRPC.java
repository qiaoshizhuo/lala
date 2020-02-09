package com.cloud.feign.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@FeignClient(value = "goods")
public interface GoodsRPC {
    @RequestMapping(value = "/goods",method = RequestMethod.GET)
    String getAll(@RequestParam("page") Integer page, @RequestParam("size") Integer size);
    @RequestMapping(value = "/goods/{id}",method = RequestMethod.GET)
    String getProduct(@PathVariable("id") Long p_id);
    @RequestMapping(value = "/good/{id}",method = RequestMethod.POST)
    String  getGood(@PathVariable("id") Long p_id);

}
