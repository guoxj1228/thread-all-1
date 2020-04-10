package com.xj.实战java高并发程序设计.dierzhang;

public class SespendResumeThread {

    public static Object object = new Object();
    static ChangeObjectThread c1 = new ChangeObjectThread("t1");
    static ChangeObjectThread c2 = new ChangeObjectThread("t2");

    public static class ChangeObjectThread extends Thread{

        public ChangeObjectThread(String name){
            super.setName(name);
        }

        @Override
        public void run(){
            synchronized (object){
                System.out.println("in "+getName());
                Thread.currentThread().suspend();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        c1.start();
        Thread.sleep(1000);
        c2.start();
        c1.resume();
        c2.resume();
        c1.join();
        c2.join();
    }
}
