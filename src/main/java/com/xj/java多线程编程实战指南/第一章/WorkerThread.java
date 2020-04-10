package com.xj.java多线程编程实战指南.第一章;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class WorkerThread {

    public static Helper helper = Helper.getHelper();
    public static void main(String[] args) {
        System.out.println(helper);
        helper.init();

        //此处，helper的客户端线程为main线程
        helper.submit("Something...");



    }

//    static class Helper{
//        private final BlockingQueue<String> workerQueue = new ArrayBlockingQueue<>(100);
//
//        //用于处理队列workerQueue中的任务工作线程
//        private final Thread workerThread = new Thread(){
//
//            @Override
//            public void run(){
//                String task = null;
//                while(true){
//                    try {
//                        task = workerQueue.take();
//                    }catch (Exception e){
//                        e.printStackTrace();
//                    }
//                    System.out.println(doProcess(task));
//                }
//            }
//
//
//        };
//
//        public void init(){
//            workerThread.start();
//        }
//
//
//        private String doProcess(String task) {
//            return task + "-> process.";
//        }
//
//        public void submit (String task){
//            try {
//                workerQueue.put(task);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
