package com.xj.实战java高并发程序设计.diwuzhang;

public class Singleton {

    /**
     * 饿汉式
     */
    public static class Singleton1{
        private Singleton1(){
            System.out.println("实例被创建");
        }

        private static Singleton1 Singleton1 = new Singleton1();

        public static Singleton1 getInstance(){
            return Singleton1;
        }
    }

    /**
     * 懒汉式
     */
    public static class Singleton2{

        private static Singleton2 singleton2;

        private Singleton2(){
            System.out.println("sington2 is created");
        }

        public static Singleton2 getInstance(){
            synchronized (singleton2.getClass()){
                if (singleton2 == null){
                    singleton2 = new Singleton2();
                }
            }

            return singleton2;
        }
    }

}
