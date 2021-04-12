package com.example.demo;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2021/4/2 14:03
 */
public class TestDemo {
    public static void main(String[] args) {

        boolean flag = false;
        long startTime= Long.valueOf("1617333583000");
        long endTime= Long.valueOf("1617247136000");
        long nowTime = System.currentTimeMillis();
        if (nowTime>=startTime && nowTime<=endTime){
            flag = true;
        }

        System.out.println(flag);
    }
}