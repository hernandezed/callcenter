package com.callcenter;

import com.callcenter.domain.Call;
import com.callcenter.domain.Customer;
import com.callcenter.domain.CustomerUtils;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Semaphore;

public class CallCenterApplication {

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        CallDispatcher callDispatcher = new CallDispatcher(EmployeeUtils.buildBasicCallCenter());
        List<Customer> customers = CustomerUtils.makeTenCustomers();
        for (Customer customer : customers) {
            callDispatcher.dispatchCall(new Call(customer));
        }

    }
}
