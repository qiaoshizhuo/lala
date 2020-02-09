package com.cloud.ribbon.controller;

import com.cloud.ribbon.entity.billing;
import com.cloud.ribbon.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class BillingController {
    @Autowired
    private BillingService billingService;
    @RequestMapping(value = "/billing",method = RequestMethod.POST)
    public billing isBilling(@RequestParam("o_id") Long o_id)
    {
        return billingService.setBilling(o_id);
    }
    @RequestMapping(value = "/addBilling",method = RequestMethod.POST)
    public billing addBilling(@RequestParam("o_id") Long o_id)
    {
        return billingService.addBilling(o_id);
    }
    @RequestMapping(value = "/getBilling",method = RequestMethod.GET)
    public billing getBilling(@RequestParam("o_id") Long o_id)
    {
        return billingService.getBilling(o_id);
    }

}
