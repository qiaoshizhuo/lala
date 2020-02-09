package com.cloud.feign.Test;

import com.cloud.feign.service.BillingService;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestBilling {
    @Test
    public void setBilling() {
        long o_id=1l;
        BillingService billingService = mock(BillingService.class);
        when(billingService.setBilling(o_id)).thenReturn("success");
        String success=billingService.setBilling(o_id);
        Assert.assertSame(success,"success");
    }
    @Test
    public void addBilling() {
        long o_id=1l;
        BillingService billingService = mock(BillingService.class);
        when(billingService.addBilling(o_id)).thenReturn("success");
        String success=billingService.addBilling(o_id);
        Assert.assertSame(success,"success");
    }
    @Test
    public void getBilling() {
        long o_id=1l;
        BillingService billingService = mock(BillingService.class);
        when(billingService.getBilling(o_id)).thenReturn("billing");
        String billing=billingService.getBilling(o_id);
        Assert.assertSame(billing,"billing");
    }
}
