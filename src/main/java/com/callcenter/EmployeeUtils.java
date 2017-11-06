package com.callcenter;

import com.callcenter.comparator.EmployeePriorityComparator;
import com.callcenter.domain.Operator;
import com.callcenter.domain.Director;
import com.callcenter.domain.Employee;
import com.callcenter.domain.Supervisor;
import java.util.concurrent.PriorityBlockingQueue;

public abstract class EmployeeUtils {

    public static PriorityBlockingQueue<Employee> buildBasicCallCenter() {
        PriorityBlockingQueue<Employee> priorityBlockingQueue = new PriorityBlockingQueue<Employee>(10, new EmployeePriorityComparator());

        priorityBlockingQueue.add(new Operator("Operator 1"));
        priorityBlockingQueue.add(new Operator("Operator 2"));
        priorityBlockingQueue.add(new Operator("Operator 3"));
        priorityBlockingQueue.add(new Operator("Operator 4"));
        priorityBlockingQueue.add(new Operator("Operator 5"));
        priorityBlockingQueue.add(new Operator("Operator 6"));
        priorityBlockingQueue.add(new Operator("Operator 7"));
        priorityBlockingQueue.add(new Operator("Operator 8"));
        priorityBlockingQueue.add(new Supervisor("Supervisor 1"));
        priorityBlockingQueue.add(new Director("Director 1"));

        return priorityBlockingQueue;
    }

}
