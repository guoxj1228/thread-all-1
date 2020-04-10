package com.xj.实战java高并发程序设计.disanzhang;

import java.util.concurrent.locks.ReentrantLock;

public class ReenterLock implements Runnable {

    public static ReentrantLock lock = new ReentrantLock();
    public static int i =0;

    @Override
    public void run() {

        for(int j=0; j < 10000000; j++){
            lock.lock();
            try {
                i++;
            }finally {
                lock.unlock();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLock r1 = new ReenterLock();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
