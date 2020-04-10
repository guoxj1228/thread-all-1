package com.xj.实战java高并发程序设计.disanzhang;

import java.util.concurrent.*;

public class RejectThreadPoolDemo {

    public static class MyTask implements Runnable{

        @Override
        public void run() {
            System.out.println("Thread Id: "+Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public static void main(String[] args) throws InterruptedException {
        MyTask task = new MyTask();
        ExecutorService e = new ThreadPoolExecutor(5,
                5,
                0L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10),
                Executors.defaultThreadFactory(),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println(r.toString()+" is discard");
                    }
                });


        for (int i = 0; i < Integer.MAX_VALUE;i++){
            e.submit(task);
            Thread.sleep(100);
        }
    }
}
