package com.cloud.feign.rpc;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "user")
public interface UserRPC {
    @RequestMapping(value = "/user/{id}")
    String getUser(@PathVariable("id")Long u_id);
    @RequestMapping(value = "/login",method = RequestMethod.POST )
    String getUserByName(@RequestParam("u_name") String u_name, @RequestParam("u_password")String u_password);
}
