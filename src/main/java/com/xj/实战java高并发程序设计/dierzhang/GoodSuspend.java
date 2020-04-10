package com.xj.实战java高并发程序设计.dierzhang;

public class GoodSuspend {
    public static Object u = new Object();

    public static class ChangeObjectThread extends Thread{

        volatile Boolean suspendMe = false;

        public void suspendMe(){
            suspendMe = true;
        }

        public void resumeMe(){
            suspendMe = false;
            synchronized (this){
                notify();
            }
        }

        @Override
        public void run(){
            while(true){
                synchronized (this){
                    while(suspendMe){
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    synchronized (u){
                        try {
                            Thread.currentThread().sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("in ChangeObjectThread");
                    }
                    Thread.yield();
                }
            }
        }
    }

    public static class ReadObjectThread extends Thread{

        @Override
        public void run(){
            while (true){
                synchronized (u){
                    try {
                        Thread.currentThread().sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("in ReadObjectThread");
                }
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ChangeObjectThread t1 = new ChangeObjectThread();
        ReadObjectThread t2 = new ReadObjectThread();

        t1.start();
        t2.start();

        Thread.sleep(1000);
        t1.suspendMe();
        System.out.println("suspend t1 2 sec................................");
        Thread.sleep(2000);
        System.out.println("resume t1.........................................");
        t1.resumeMe();
    }
}
