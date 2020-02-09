package com.cloud.feign.service;

import com.cloud.feign.rpc.BillingRPC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillingService {
    @Autowired
    private BillingRPC billingRPC;

    public String setBilling(Long o_id) {
        return billingRPC.isBilling(o_id);
    }
    public String addBilling(Long o_id) {
        return billingRPC.addBilling(o_id);
    }
    public String getBilling(Long o_id) {
        return billingRPC.getBilling(o_id);
    }
}
