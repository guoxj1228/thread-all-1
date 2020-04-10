package com.xj.实战java高并发程序设计.dierzhang;

public class WaitNotifyThread {

    private static Object o = new Object();

    public static class T1 extends Thread{
        @Override
        public void run(){
            synchronized (o){
                System.out.println(System.currentTimeMillis()+":T1 start! ");
                try {
                    System.out.println(System.currentTimeMillis()+":T1 wait for Object ");
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis()+":T1 end! ");
            }
        }
    }

    public static class T2 extends Thread{
        @Override
        public void run(){
            synchronized (o){
                System.out.println(System.currentTimeMillis()+":T2 start! notify one Thread");

                o.notify();

                System.out.println(System.currentTimeMillis()+":T2 end!");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new T1();
        Thread t2 = new T2();

        t1.start();
        t2.start();

        /**
         * 1572573495000:T1 start!
         * 1572573495000:T1 wait for Object
         * 1572573495000:T2 start! notify one Thread
         * 1572573495000:T2 end!
         * 1572573497000:T1 end!
         *
         * 可以看到T2通知T1后继续执行后，T1并不能继续执行，而是等待T2释放object锁，
         * 并重新成功获得锁后，才能执行。
         *
         * wait和sleep方法 都可以让线程等待若干时间，除了wait可以被唤醒外，
         * 另外一个主要区别是，wait释放目标对象锁，sleep不会释放任何资源
         */
    }
}
