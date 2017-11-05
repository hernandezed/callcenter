package com.callcenter.domain;

public class StandBy implements Runnable {

    @Override
    public void run() {
        System.out.println("All operators are busy at the moment - playing MUSIC");
    }

}
