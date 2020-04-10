package com.xj.实战java高并发程序设计.diwuzhang;

public class FutureData implements Data{

    protected RealData realData;
    protected volatile boolean isReady = false;

    public synchronized void setRealData(RealData realData) throws InterruptedException {

        if (isReady){
            return;
        }

        this.realData = realData;
        isReady = true;
        notifyAll();
    }

    public synchronized RealData getRealData() throws InterruptedException {
        while (!isReady){
            wait();
        }
        return realData;
    }
}
