package com.xj.实战java高并发程序设计.disanzhang;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class IntLock implements Runnable {

    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    int lock;

    public IntLock(int i){
        this.lock = i;
    }
    @Override
    public void run() {

        try {
            if (lock == 1){
                System.out.println(Thread.currentThread().getId()+"等待lock1");
                lock1.lockInterruptibly();
                System.out.println(Thread.currentThread().getId()+"拿到lock1");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getId()+"等待lock2");
                lock2.lockInterruptibly();
                System.out.println(Thread.currentThread().getId()+"拿到lock2");
//                lock2.unlock();
            }else{
                System.out.println(Thread.currentThread().getId()+"等待lock2");
                lock2.lockInterruptibly();
                System.out.println(Thread.currentThread().getId()+"拿到lock2");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getId()+"等待lock1");
                lock1.lockInterruptibly();
                System.out.println(Thread.currentThread().getId()+"拿到lock1");

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock1.isHeldByCurrentThread()){
                System.out.println("释放lock1");
                lock1.unlock();
            }
            if (lock2.isHeldByCurrentThread()){
                System.out.println("释放lock2");
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getId()+"线程退出");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        IntLock r1 = new IntLock(1);
        IntLock r2 = new IntLock(2);

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
        System.out.println("死锁状态：开始睡眠2000ms");
        Thread.sleep(2000);
        System.out.println("死锁状态：结束睡眠2000ms");
        /**
         * 线程中断会触发抛异常动作，但是不会释放锁，需要再finally中手动释放锁
         */
        t2.interrupt();
    }



}
