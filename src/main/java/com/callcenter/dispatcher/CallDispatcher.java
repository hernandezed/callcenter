package com.callcenter.dispatcher;

import com.callcenter.domain.Call;
import com.callcenter.domain.Employee;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CallDispatcher {

    Semaphore operatorsSemaphore;
    PriorityBlockingQueue<Employee> freeOperatorQueue;
    AtomicInteger callCounter;
    ExecutorService executorService = Executors.newCachedThreadPool();

    public CallDispatcher(PriorityBlockingQueue<Employee> freeOperatorQueue) {
        operatorsSemaphore = new Semaphore(freeOperatorQueue.size());
        this.freeOperatorQueue = freeOperatorQueue;
        callCounter = new AtomicInteger(0);

        System.out.println("The call center is ready to answer phone calls");
        System.out.println("Available operators initially=" + operatorsSemaphore.availablePermits());
    }

    public Future<Call> dispatchCall(Call call) {
        return executorService.submit(() -> {
            int duration = ThreadLocalRandom.current().nextInt(5, 10);
            call.setDuration(duration);
            try {
                System.out.println(call.getCustomer().getName() + " is waiting to speak to the operator whit phone number " + call.getCustomer().getPhone());
                operatorsSemaphore.acquire();
                Employee employee = (Employee) freeOperatorQueue.remove();
                call.setEmployee(employee);
                call.setOrder(callCounter.addAndGet(1));
                
                System.out.println(call.getCustomer().getName() + " is getting the connection to the operator.");
                
                Thread.sleep(TimeUnit.SECONDS.toMillis(duration));
                
                System.out.println(call);
                freeOperatorQueue.add(employee);
                operatorsSemaphore.release();
                executorService.shutdown();
            } catch (InterruptedException e) {
                System.err.println(e);
            }
            return call;
        });
    }

}
