package com.xj.实战java高并发程序设计.dierzhang;

public class JoinThread {

    public volatile static int i = 0;

    public static class AddThread extends Thread{
        @Override
        public void run(){
            System.out.println("计算前...");
            for (i = 0; i < 10000000; i++);
            System.out.println("计算后...");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AddThread at = new AddThread();
        at.start();
        System.out.println("join 前...");
        at.join();
        System.out.println("join 后...");
        System.out.println(i);
    }
}
