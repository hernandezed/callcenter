package com.callcenter.dispatcher;

import com.callcenter.domain.Employee;
import com.callcenter.domain.StandBy;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;

public class CallDispatcher {

    private PriorityBlockingQueue<Employee> freeEmployeesQueue;
    private Semaphore semaphore;
    private CyclicBarrier cyclicBarrier;

    public CallDispatcher(PriorityBlockingQueue<Employee> freeEmployeesQueue) {
        this.freeEmployeesQueue = freeEmployeesQueue;
        semaphore = new Semaphore(freeEmployeesQueue.size());
        cyclicBarrier = new CyclicBarrier(freeEmployeesQueue.size(), new StandBy());

        System.out.println("The call center is ready to answer phone calls");
        System.out.println("Available operators initially=" + freeEmployeesQueue.size());

    }

}
