package com.xj.实战java高并发程序设计.diliuzhang;

import com.sun.xml.internal.ws.util.CompletedFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {

    public static Integer calc(Integer para){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return para * para;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> calc(50))
                .thenApply((i) -> Integer.toString(i))
                .thenApply((str) -> "\""+str+"\"")
                .thenAccept(System.out::println);




        System.out.println(System.currentTimeMillis());
        System.out.println(future.get());
        System.out.println(System.currentTimeMillis());
    }
}
