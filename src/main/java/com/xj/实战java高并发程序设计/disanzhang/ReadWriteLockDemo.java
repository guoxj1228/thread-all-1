package com.xj.实战java高并发程序设计.disanzhang;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {

    static ReentrantLock lock = new ReentrantLock();
    static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static Lock readLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();
    static Integer value;

    public static Integer handleRead(Lock lock){
        try {
            lock.lock();
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getId()+"读取value： "+value);
            return value;

        } catch (InterruptedException e) {
            e.printStackTrace();
            return value;
        } finally {
            lock.unlock();
        }
    }

    public void handleWrite(Lock lock, Integer index){
        try {
            lock.lock();
            value = index;
            System.out.println(Thread.currentThread().getId()+"写入value： "+index);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        final ReadWriteLockDemo demo = new ReadWriteLockDemo();

        Runnable readRunnable = new Runnable() {
            @Override
            public void run() {

//                demo.handleRead(readLock);
                demo.handleRead(lock);
                System.out.println(System.currentTimeMillis());
            }
        };

        Runnable writeRunnable = new Runnable() {
            @Override
            public void run() {

//                demo.handleWrite(writeLock, new Random().nextInt());
                demo.handleWrite(lock, new Random(10).nextInt());
                System.out.println(System.currentTimeMillis());
            }
        };

        long ts = System.currentTimeMillis();


        for (int i = 18; i < 20; i++){
            Thread t = new Thread(writeRunnable);
            t.start();
//            t.join();
        }

        for (int i = 0; i < 18; i++){
            Thread t = new Thread(readRunnable);
            t.start();
//            t.join();
        }
        long te = System.currentTimeMillis();

        System.out.println("运行耗时： "+(te-ts)+"ms");
    }








//    private static Lock lock = new ReentrantLock();
//    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
//    private static Lock readLock = readWriteLock.readLock();
//    private static Lock writeLock = readWriteLock.writeLock();
//    private int value;
//
//    public Object handleRead(Lock lock) throws InterruptedException {
//        try {
//            lock.lock();
//            Thread.sleep(1000);
//            System.out.println(System.currentTimeMillis()+", 读数据:"+value);
//            return value;
//        }finally {
//            lock.unlock();
//        }
//    }
//
//
//    public void handleWrite(Lock lock, int index) throws InterruptedException {
//        try {
//            lock.lock();
//            Thread.sleep(1000);
//            value = index;
//            System.out.println(System.currentTimeMillis()+", 写数据："+index);
//        }finally {
//            lock.unlock();
//        }
//    }
//
//    public static void main(String[] args) {
//        final ReadWriteLockDemo demo = new ReadWriteLockDemo();
//        Runnable readRunnable = new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    demo.handleRead(readLock);
////                    demo.handleRead(lock);
//                }catch (InterruptedException e){
//                    e.printStackTrace();
//                }
//            }
//        };
//
//        Runnable writeRunnable = new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    demo.handleWrite(writeLock, new Random().nextInt(5));
////                demo.handleWrite(lock, new Random().nextInt(5));
//                }catch (InterruptedException e){
//                    e.printStackTrace();
//                }
//            }
//        };
//
////        System.out.println("开始执行："+System.currentTimeMillis());
//        for (int i=18; i<20; i++){
//            new Thread(writeRunnable).start();
//        }
//
//        for (int i=0; i < 18; i++){
//            new Thread(readRunnable).start();
//        }
//
//
////        System.out.println("结束执行："+System.currentTimeMillis());
//    }

}
