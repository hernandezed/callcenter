package com.callcenter.comparator;

import com.callcenter.domain.Employee;
import java.util.Comparator;

public class EmployeePriorityComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.getPriority() < o2.getPriority()) {
            return -1;
        } else if (o1.getPriority() > o2.getPriority()) {
            return 1;
        }
        return 0;
    }

}
