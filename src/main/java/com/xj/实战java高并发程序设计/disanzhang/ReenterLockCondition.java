package com.xj.实战java高并发程序设计.disanzhang;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReenterLockCondition implements Runnable {

    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();


    @Override
    public void run() {

        try {
            lock.lockInterruptibly();
            System.out.println("进入等待...");
            condition.await();
            System.out.println("Thread gong on!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLockCondition r = new ReenterLockCondition();
        Thread t = new Thread(r);

        t.start();

        System.out.println("睡眠2秒...");
        Thread.sleep(2000);


        lock.lockInterruptibly();
        System.out.println("唤醒线程...");
        condition.signal();
        lock.unlock();

    }

//    public static ReentrantLock lock = new ReentrantLock();
//    public static Condition condition = lock.newCondition();
//
//    @Override
//    public void run() {
//        try {
//            lock.lock();
//            System.out.println("线程进入等待...");
//            condition.await();
//            System.out.println("Thread is going on");
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }finally {
//            lock.unlock();
//        }
//    }
//
//    public static void main(String[] args) throws InterruptedException {
//        /**
//         * 等待方法会释放锁资源，
//         * 主线程拿到锁之后，顺利执行，唤醒等待线程，
//         * 但是等待线程需等待主线程将锁资源释放之后，
//         * 才能拿到锁资源，继续执行
//         *
//         */
//        ReenterLockCondition r1 = new ReenterLockCondition();
//        Thread t1 = new Thread(r1);
//        t1.start();
//        System.out.println("启动线程之后，睡眠两秒...");
//        Thread.sleep(2000);
//        //通知线程t1继续执行
//        lock.lock();
//        System.out.println("唤醒等待线程...");
//        condition.signal();
//        System.out.println("睡眠两秒...");
//        Thread.sleep(2000);
//        System.out.println("主线程释放锁资源...");
//        lock.unlock();
//    }
}
