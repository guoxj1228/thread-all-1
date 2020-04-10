package com.xj.实战java高并发程序设计.diwuzhang;

public final class PCData {

    private final int intDate;

    public PCData(int intDate){
        this.intDate = intDate;
    }

    public int getIntDate() {
        return intDate;
    }

    @Override
    public String toString() {
        return "PCData{" +
                "intDate=" + intDate +
                '}';
    }
}
