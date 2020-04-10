package com.xj.实战java高并发程序设计.dierzhang;

public class InterrupterThread {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(){
            @Override
            public void run(){
                while (true){
                    if (Thread.currentThread().isInterrupted()){
                        System.out.println("线程中断了！");
                        break;
                    }
                    try {
                        System.out.println("进入睡眠...");
                        Thread.sleep(1500);
                        System.out.println("结束睡眠...");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println("睡眠中，出现中断！");
                        //设置线程状态为中断
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("运行中...");
                }
            }
        };

        t.start();
        t.sleep(1000);
        t.interrupt();
    }
}
