package com.xj.实战java高并发程序设计.disanzhang;

import javafx.concurrent.Task;
import org.omg.SendingContext.RunTime;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExtThreadPool {

    public static class MyTask implements Runnable{

        public String name;

        public MyTask(String name){
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("Thread Id: "+Thread.currentThread().getId()+", Task name: "+name+",正在执行！");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) throws InterruptedException {
            ExecutorService e = new ThreadPoolExecutor(5,
                    5,
                    0L,
                    TimeUnit.SECONDS,
                    new ArrayBlockingQueue<>(10)){

                @Override
                protected void beforeExecute(Thread t, Runnable r){
                    System.out.println("准备执行： "+((MyTask)r).name);
                }

                @Override
                protected void afterExecute(Runnable r, Throwable t){
                    System.out.println("执行完成： "+((MyTask)r).name);
                }

                @Override
                protected void terminated(){
                    System.out.println("线程池退出");
                }
            };


            for (int i = 0;i < 5;i++){
                MyTask task = new MyTask("Task-Geym-"+i);
                e.execute(task);
                Thread.sleep(100);
            }

            e.shutdown();

            int i = Runtime.getRuntime().availableProcessors();
            System.out.println("cpu: "+i);
        }
    }
}
