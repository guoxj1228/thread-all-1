package com.xj.实战java高并发程序设计.diliuzhang;

import java.util.stream.IntStream;

public class PrimeUtil {

    public static Boolean isPrimeUtil(int num){
        int tmp = num;
        if (tmp < 2){
            return false;
        }

        for (int i = 2; Math.sqrt(tmp) >= i; i++){
            if (tmp % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IntStream.range(1, 1000000).parallel().filter(PrimeUtil::isPrimeUtil).forEach(System.out::println);
    }
}
