package com.xj.java多线程编程实战指南.第一章;

public class NonThreadSafeCounter {
    private int counter = 0;

    public void increment(){
        counter++;
    }

    public int get(){
        return counter;
    }
}
