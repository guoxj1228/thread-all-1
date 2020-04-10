package com.xj.实战java高并发程序设计.diliuzhang;

import com.sun.xml.internal.ws.util.CompletedFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

public class AskThread implements Runnable {

    CompletableFuture<Integer> re = null;

    public AskThread(CompletableFuture<Integer> re){
        this.re = re;
    }

    @Override
    public void run() {
        int myRe = 0;
        try{
            myRe = re.get() * re.get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(myRe);
    }

    public static void main(String[] args) throws InterruptedException {
        final CompletableFuture<Integer> future = new CompletableFuture <>();
        new Thread(new AskThread(future)).start();

        Thread.sleep(1000);

        future.complete(60);
    }
}
