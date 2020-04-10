package com.xj.实战java高并发程序设计.diwuzhang;

import java.util.concurrent.Callable;

public class RealDataJDK implements Callable<String> {

    private String data;

    public RealDataJDK(String data){
        this.data = data;
    }

    @Override
    public String call() throws Exception {

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++){
            sb.append(data);

            Thread.sleep(100);
        }



        return sb.toString();

    }
}
