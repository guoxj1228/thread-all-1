package com.xj.实战java高并发程序设计.disanzhang;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo implements Runnable {

    static CountDownLatch end = new CountDownLatch(10);

    @Override
    public void run() {

        try {
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getId()+": 检查完毕!");
            end.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executors = Executors.newFixedThreadPool(10);
        CountDownLatchDemo demo = new CountDownLatchDemo();


        for (int i = 0; i < 10;i++){
            executors.submit(demo);
        }

        //等待检查
        end.await();

        System.out.println("点火");
        executors.shutdown();
    }



//    static final CountDownLatch end = new CountDownLatch(10);
//    static final CountDownLatchDemo demo = new CountDownLatchDemo();
//
//    @Override
//    public void run() {
//        try {
//            //模拟检查任务
//            Thread.sleep(new Random().nextInt(10) * 1000);
//            System.out.println(Thread.currentThread().getId()+" check complete");
//            end.countDown();
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) throws InterruptedException {
//        ExecutorService exec = Executors.newFixedThreadPool(10);
//        for (int i= 0; i < 10; i++){
//            exec.submit(demo);
//        }
//        //等待检查
//        end.await();
//        //等待火箭
//        System.out.println("Fire!");
//        exec.shutdown();
//    }
}
