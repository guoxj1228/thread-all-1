package com.xj.实战java高并发程序设计.diwuzhang;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Plus implements Runnable {

    public static BlockingQueue<Msg> queue = new LinkedBlockingQueue<>();

    @Override
    public void run() {

        while(true){
            try {
                Msg msg = queue.take();
                msg.j = msg.i + msg.j;
                Mutiply.queue.add(msg);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
