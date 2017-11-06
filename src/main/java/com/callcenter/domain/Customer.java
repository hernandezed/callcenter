package com.callcenter.domain;

public class Customer {

    private String name;
    private String phone;

    public Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        StringBuilder customerStringBuilder = new StringBuilder("Name: ")
                .append(name).append(" Phone: ").append(phone);
        return customerStringBuilder.toString();
    }

}
