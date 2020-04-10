package com.xj.实战java高并发程序设计.diwuzhang;

public class Msg {
    public double i;
    public double j;
    public String orgStr = null;


    public static void main(String[] args) {
        new Thread(new Plus()).start();
        new Thread(new Mutiply()).start();
        new Thread(new Div()).start();

        for (int i = 0; i < 100; i++){
            for (int j = 0; j < 100; j++){
                Msg msg = new Msg();
                msg.i = i;
                msg.j = j;
                msg.orgStr = "(("+i+" + "+j+") * "+i+")/2";
                Plus.queue.add(msg);
            }

        }
    }
}
