package com.xj.实战java高并发程序设计.dierzhang;

public class GroupThread implements Runnable{

    public static void main(String[] args) {
        ThreadGroup tg = new ThreadGroup("printGroup");
        Thread t1 = new Thread(tg, new GroupThread(),"T1");
        Thread t2 = new Thread(tg, new GroupThread(),"T2");
        t1.start();
        t2.start();
        System.out.println(tg.activeCount());
        tg.list();
    }

    @Override
    public void run() {
        String groupAndName = Thread.currentThread().getThreadGroup().getName()+"-"+Thread.currentThread().getName();
        while (true){
            System.out.println("I am "+groupAndName);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

