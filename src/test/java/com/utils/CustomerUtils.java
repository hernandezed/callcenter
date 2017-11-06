package com.utils;

import com.callcenter.domain.Customer;
import java.util.ArrayList;
import java.util.List;

public abstract class CustomerUtils {

    public static List<Customer> makeTenCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Maria", "+541146669845"));
        customers.add(new Customer("Luis", "+541146679345"));
        customers.add(new Customer("Hector", "+54112311234"));
        customers.add(new Customer("Teo", "+54112311234"));
        customers.add(new Customer("Luisa", "+54112618204"));
        customers.add(new Customer("Roberto", "+54114314232"));
        customers.add(new Customer("Penelope", "+54115313264"));
        customers.add(new Customer("Julian", "+54112312237"));
        customers.add(new Customer("Juliana", "+54112310839"));
        customers.add(new Customer("Tomas", "+54116318809"));
        return customers;
    }

}
