package com.xj.实战java高并发程序设计.disanzhang;

import com.xj.实战java高并发程序设计.dierzhang.ArrayListMultiThread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {

    public static AtomicInteger i = new AtomicInteger();

    public static class AddThread implements Runnable{

        @Override
        public void run() {
            for (int j = 0; j < 10000; j++){
                i.getAndIncrement();
            }

        }
    }


    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++){
            Thread t = new Thread(new AddThread());
            t.start();
            t.join();
        }

        System.out.println(i);
    }
}
