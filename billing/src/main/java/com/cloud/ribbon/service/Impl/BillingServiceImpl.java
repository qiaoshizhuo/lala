package com.cloud.ribbon.service.Impl;

import com.cloud.ribbon.entity.billing;
import com.cloud.ribbon.repository.BillingRepository;
import com.cloud.ribbon.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillingServiceImpl implements BillingService {
    @Autowired
    private BillingRepository billingRepository;

    @Override
    public billing setBilling(Long o_id) {
        billing billing = billingRepository.getBilling(o_id);
        billing.setIsBilling(1);
        return billingRepository.save(billing);

    }

    @Override
    public billing addBilling(Long o_id) {
        billing billing=new billing();
        billing.setIsBilling(0);
        billing.setO_id(o_id);
        return billingRepository.save(billing);

    }

    @Override
    public billing getBilling(Long o_id) {
        return billingRepository.getBilling(o_id);
    }
}
