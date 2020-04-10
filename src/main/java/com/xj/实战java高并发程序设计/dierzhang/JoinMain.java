package com.xj.实战java高并发程序设计.dierzhang;

public class JoinMain {
    public volatile static int i = 0;
    public static class AddThread extends Thread{
        @Override
        public void run(){
            for (i=0;i<10000000;i++);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AddThread at = new AddThread();
        at.start();
        at.join();
        System.out.println("i: "+i);

    }
}
