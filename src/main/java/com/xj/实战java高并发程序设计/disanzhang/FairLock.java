package com.xj.实战java高并发程序设计.disanzhang;

import java.util.concurrent.locks.ReentrantLock;

public class FairLock implements Runnable {

    public ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true){
        try {

                lock.lockInterruptibly();
                System.out.println(Thread.currentThread().getId()+" is done!");



        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        }
    }

    public static void main(String[] args) {
        FairLock f = new FairLock();
        Thread t1 = new Thread(f);
        Thread t2 = new Thread(f);

        t1.start();
        t2.start();
    }
}
