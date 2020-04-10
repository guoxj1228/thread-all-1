package com.xj.实战java高并发程序设计.diwuzhang;

import java.util.concurrent.*;

public class FutureDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<String> future = new FutureTask<String>(new RealData("a"));
        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.execute(future);
        System.out.println("请求完毕");
        Thread.sleep(2000);
        System.out.println("数据："+future.get());
        executor.shutdown();
    }


    public static class RealData implements Callable<String>{

        private String para;
        public RealData(String para){
            this.para = para;
        }

        @Override
        public String call() throws Exception {
            StringBuffer sb = new StringBuffer();
            for (int i=0; i < 10; i++){
                sb.append(para);
                Thread.sleep(100);

            }
            return sb.toString();
        }
    }
}
