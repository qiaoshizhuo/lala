package com.cloud.ribbon.service;

import com.cloud.ribbon.entity.billing;

import java.util.Optional;

public interface BillingService {
    billing setBilling(Long o_id);
    billing addBilling(Long o_id);
    billing getBilling(Long o_id);
}
