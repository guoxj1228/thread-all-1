package com.xj.实战java高并发程序设计.diwuzhang;

public class Client {
    public Data request(final String param){
        FutureData futureData = new FutureData();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    RealData data = new RealData(param);
                    futureData.setRealData(data);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        return futureData;
    }


    public static void main(String[] args) throws InterruptedException {
        Client client = new Client();
        //立即返回，得到的是futureData，而非RealData
        FutureData data = (FutureData) client.request("gxj");

        //模拟其他业务
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        RealData realData = data.getRealData();
        System.out.println("得到数据： "+realData.toString());

    }
}
