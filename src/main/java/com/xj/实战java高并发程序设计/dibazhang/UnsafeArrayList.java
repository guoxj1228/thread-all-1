package com.xj.实战java高并发程序设计.dibazhang;

import java.util.ArrayList;

public class UnsafeArrayList {

    static ArrayList al = new ArrayList();

    static class AddTask implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < 1000000; i++){
                al.add(new Object());
            }
        }


    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new AddTask(),"t1");
        Thread t2 = new Thread(new AddTask(),"t2");

        t1.start();
        t2.start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"t3").start();
    }
}
