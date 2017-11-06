package com.callcenter.domain;

public class Call {

    private Employee employee;
    private Customer customer;
    private int duration;
    private int order;

    public Call(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getDuration() {
        return duration;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        StringBuilder summary = new StringBuilder("Summary from call number ")
                .append(order).append("\n")
                .append("Customer: ").append(customer.toString()).append("\n")
                .append("Employee: ").append(employee.getName());
        return summary.toString();
    }

}
