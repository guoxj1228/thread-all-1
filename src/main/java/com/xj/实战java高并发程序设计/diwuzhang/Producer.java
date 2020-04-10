package com.xj.实战java高并发程序设计.diwuzhang;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {

    private volatile Boolean isRunning = true;
    private BlockingQueue<PCData> queue;
    private static AtomicInteger count = new AtomicInteger();
    private static final int SLEEPTIME = 1000;

    public Producer(BlockingQueue<PCData> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        PCData data = null;
        Random r = new Random();
        while (isRunning){
            try {
                Thread.sleep(r.nextInt(SLEEPTIME));
                data = new PCData(count.getAndIncrement());
                System.out.println("生产数据: "+data.toString());

                if (!queue.offer(data,1, TimeUnit.SECONDS)){
                    System.out.println("生产数据超时："+data.toString());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop(){
        this.isRunning = false;
    }
}
