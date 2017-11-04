package com.callcenter.domain;

public class Supervisor extends Employee {

    public Supervisor(String name) {
        this.name = name;
        this.priority = 2;
    }

    @Override
    public void attend(Call call) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
