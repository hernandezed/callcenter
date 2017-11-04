package com.callcenter.domain;

public abstract class Employee {

    protected String name;
    protected int priority;

    public abstract void attend(Call call);

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

}
