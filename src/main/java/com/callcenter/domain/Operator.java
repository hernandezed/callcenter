package com.callcenter.domain;

public class Operator extends Employee {

    public Operator(String name) {
        this.name = name;
        this.priority = 1;
    }

    @Override
    public void attend(Call call) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
