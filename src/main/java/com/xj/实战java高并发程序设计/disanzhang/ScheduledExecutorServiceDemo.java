package com.xj.实战java高并发程序设计.disanzhang;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceDemo {

    public static void main(String[] args) {
        ScheduledExecutorService s = Executors.newScheduledThreadPool(10);

        /**
         * 任务运行时间超过调度时间，则任务运行完成就会直接调度下个任务
         * 相当于任务处理时间就会变成调度时间
         */
//        s.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getId()+" : "+System.currentTimeMillis()/1000);
//                try {
//                    Thread.sleep(4000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },0,2, TimeUnit.SECONDS);


        s.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getId()+" : "+System.currentTimeMillis()/1000);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },0,2,TimeUnit.SECONDS);
    }
}
