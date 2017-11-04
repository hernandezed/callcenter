package com.callcenter.domain;

public class Director extends Employee {

    public Director(String name) {
        this.name = name;
        this.priority = 3;
    }

    @Override
    public void attend(Call call) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
