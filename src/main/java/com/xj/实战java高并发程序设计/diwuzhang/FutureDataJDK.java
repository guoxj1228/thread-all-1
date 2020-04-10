package com.xj.实战java高并发程序设计.diwuzhang;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureDataJDK {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //构造FutureTask
        FutureTask<String> future = new FutureTask<>(new RealDataJDK("gxj"));
        ExecutorService e = Executors.newFixedThreadPool(1);
        //执行
        e.submit(future);

        System.out.println("请求完毕");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println("数据： "+future.get());


    }
}
