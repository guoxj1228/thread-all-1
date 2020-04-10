package com.xj.实战java高并发程序设计.diwuzhang;

public class RealData implements Data{

    private String result;
    public RealData(String param) throws InterruptedException {

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10;i++){
            sb.append(param);
            Thread.sleep(100);
        }

        result = sb.toString();
    }

    public String getResult(){
        return result;
    }

}
