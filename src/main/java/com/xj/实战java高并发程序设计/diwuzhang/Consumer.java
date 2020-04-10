package com.xj.实战java高并发程序设计.diwuzhang;

import org.omg.SendingContext.RunTime;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.*;

public class Consumer implements Runnable {

    private BlockingQueue<PCData> queue;
    private volatile Boolean isRunning = true;
    private final static int SLEEPTIME = 1000;

    public Consumer(BlockingQueue<PCData> queue){
        this.queue = queue;
    }

    @Override
    public void run() {

        Random r = new Random();
        while (isRunning){
            try {
                PCData data = queue.take();
                Integer intData = data.getIntDate();
//                System.err.println("拿到数据： "+data.toString());
                if (data != null){
                    Integer res = intData * intData;

                    System.err.println(MessageFormat.format("消费数据，并处理： {0} * {1}={2}",intData,intData,res));
                    Thread.sleep(r.nextInt(SLEEPTIME));
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void stop(){
        this.isRunning = false;
    }

    public static void main(String[] args) throws InterruptedException {

        LinkedBlockingQueue queue = new LinkedBlockingQueue(10);
        Producer p1 = new Producer(queue);
        Producer p2 = new Producer(queue);
        Producer p3 = new Producer(queue);

        Consumer c1 = new Consumer(queue);
        Consumer c2 = new Consumer(queue);
        Consumer c3 = new Consumer(queue);


        int i = Runtime.getRuntime().availableProcessors();
        ExecutorService e = Executors.newFixedThreadPool(i*2);

        e.submit(p1);
        e.submit(p2);
        e.submit(p3);

        e.submit(c1);
        e.submit(c2);
        e.submit(c3);

        Thread.sleep(1000 * 10);

        p1.stop();
        p2.stop();
        p3.stop();

        e.shutdown();


    }
}
