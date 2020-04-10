package com.xj.java多线程编程实战指南.第一章;

import java.util.logging.Handler;

public class ThreadSafeCounter {
    private int counter = 0;

    public void increment(){
        synchronized (this){
            counter++;
        }
    }

    public int get(){
        synchronized (this){
            return counter;
        }
    }

    public static void main(String[] args) {
       Helper helper = Helper.getHelper();
       helper.init();
        System.out.println(helper);
        for (int i = 0; i < 10;i++){
            helper.submit("提交任务"+i);
            System.out.println("提交任务"+i);
        }

    }
}
