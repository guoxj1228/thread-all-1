package com.xj.实战java高并发程序设计.dierzhang;

public class AccountingVol implements Runnable {

    static AccountingVol instance = new AccountingVol();
    static volatile  int i = 0;

    public synchronized static void increase(){
        i++;
    }

    @Override
    public void run() {
        for(int i=0; i < 10000000; i++){
            increase();
        }

    }

    public static void main(String[] args) throws InterruptedException {
//        Thread t1 = new Thread(instance);
//        Thread t2 = new Thread(instance);
        /**
         * 实例锁，应该保证同一个实例
         * 类锁，本身就是一个类，方法上加静态的就是类锁
         */
        Thread t1 = new Thread(new AccountingVol());
        Thread t2 = new Thread(new AccountingVol());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }

}
