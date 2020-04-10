package com.xj.java多线程编程实战指南.第一章;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Helper {

    private final static BlockingQueue<String> workerQueue = new ArrayBlockingQueue<>(100);

    public static Helper helper;

    private Helper(){

    }

    public static synchronized Helper getHelper(){
        if (helper == null){
            helper = new Helper();
        }
        return helper;
    }


    //用于处理队列workerQueue中的任务工作线程
    private final Thread workerThread = new Thread(){

        @Override
        public void run(){
            String task = null;
            while(true){
                try {
                    System.out.println(workerQueue.size());
                    task = workerQueue.take();
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println(doProcess(task));
            }
        }


    };

    public void init(){
        workerThread.start();
    }


    private String doProcess(String task) {
        return task + "-> process.";
    }

    public void submit (String task){
        try {
            System.out.println("submit: "+task);
            System.out.println("submit,queue.size: "+workerQueue.size());
            workerQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
