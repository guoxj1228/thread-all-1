package com.xj.实战java高并发程序设计.diliuzhang;

import java.util.Arrays;

public class FunctionCode {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,2,4,6,8};

        Arrays.stream(arr).map((x)->x=x+1).forEach(System.out::println);
//        System.out.println();
//        Arrays.stream(arr).forEach(System.out::print);

//        Arrays.stream(arr).map(x->(x%2==0?x:x+1)).forEach(System.out::println);

//        List<Integer> numbers = Arrays.asList(1,2,3,4,5,7,8,9);
//        numbers.forEach((Integer value)-> System.out.print(value+","));

//        final int num = 2;
//        int num = 2;
//        Function<Integer, Integer> stringConverter = (from)->from * num;
////        num++;
//        System.out.println(stringConverter.apply(3));
    }
}
