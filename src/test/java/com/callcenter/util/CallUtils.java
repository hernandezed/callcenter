package com.callcenter.util;

import com.callcenter.domain.Call;
import com.callcenter.domain.Customer;

public abstract class CallUtils {

    public static Call createSimpleCall() {
        Call call = new Call();
        Customer customer = new Customer("Customer", "US", "12345678");
        call.setCustomer(customer);
        return call;
    }

}
