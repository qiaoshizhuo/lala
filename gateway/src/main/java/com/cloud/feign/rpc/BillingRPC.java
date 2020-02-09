package com.cloud.feign.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "billing")
public interface BillingRPC {
    @RequestMapping(value = "/billing",method = RequestMethod.POST)
    String isBilling(@RequestParam("o_id") Long o_id);
    @RequestMapping(value = "/addBilling",method = RequestMethod.POST)
    String addBilling(@RequestParam("o_id") Long o_id);
    @RequestMapping(value = "/getBilling",method = RequestMethod.GET)
    String getBilling(@RequestParam("o_id") Long o_id);
}
