package com.xj.实战java高并发程序设计.disanzhang;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DivTask implements Runnable {

    int a,b;

    public DivTask(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        double re = a/b;
        System.out.println(a + "/" + b + "=" + re);
    }

    public static void main(String[] args) {
        ExecutorService e = new ThreadPoolExecutor(0,
                Integer.MAX_VALUE,
                0L,
                TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());

        for (int i = 0;i < 5;i++){
            e.execute(new DivTask(100,i));
        }
    }
}
