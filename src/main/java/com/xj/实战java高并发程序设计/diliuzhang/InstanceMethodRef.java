package com.xj.实战java高并发程序设计.diliuzhang;

import java.util.ArrayList;
import java.util.List;

public class InstanceMethodRef {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            users.add(new User(i,"billy"+i));
        }
        users.stream().map(User::getName).forEach(System.out::println);
    }

    static class User{
        private Integer id;
        private String name;

        public User(int i, String s) {
            this.id = i;
            this.name = s;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
