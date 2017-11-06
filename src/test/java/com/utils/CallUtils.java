package com.utils;

import com.callcenter.domain.Call;
import com.callcenter.domain.Customer;
import java.util.ArrayList;
import java.util.List;

public abstract class CallUtils {

    public static List<Call> makeTenCalls() {
        List<Call> calls = new ArrayList<>();

        for (Customer customer : CustomerUtils.makeTenCustomers()) {
            calls.add(new Call(customer));
        }
        
        return calls;
    }
}
