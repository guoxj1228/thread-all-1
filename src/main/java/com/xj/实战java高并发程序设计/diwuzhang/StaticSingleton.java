package com.xj.实战java高并发程序设计.diwuzhang;

public class StaticSingleton {
    private StaticSingleton(){
        System.out.println("StaticSingleton is created");
    }

    private static class SingletonHolder{
        private static StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance(){
        return SingletonHolder.instance;
    }
}
