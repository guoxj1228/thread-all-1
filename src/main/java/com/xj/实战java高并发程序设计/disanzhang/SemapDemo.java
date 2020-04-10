package com.xj.实战java高并发程序设计.disanzhang;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemapDemo implements Runnable {

    public final Semaphore s = new Semaphore(5);


    @Override
    public void run() {
        try {
            s.acquire();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId()+" is done!");
            s.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService executors = Executors.newFixedThreadPool(20);
        SemapDemo semapDemo = new SemapDemo();
        for (int i = 0; i < 20;i++){
            executors.submit(semapDemo);
        }


    }

//    final Semaphore semp = new Semaphore(5);
//
//
//    @Override
//    public void run() {
//        try {
//            semp.acquire();
//            //模拟耗时操作
//            Thread.sleep(2000);
//            System.out.println(Thread.currentThread().getId()+" done!");
//            semp.release();
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        ExecutorService exec = Executors.newFixedThreadPool(20);
//        final SemapDemo demo = new SemapDemo();
//        for (int i=0; i<20; i++){
//            exec.submit(demo);
//        }
//    }
}
