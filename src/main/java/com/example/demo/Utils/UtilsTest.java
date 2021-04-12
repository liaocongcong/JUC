package com.example.demo.Utils;

import java.util.Date;
import java.util.Objects;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2021/4/10 11:01
 */
public class UtilsTest {
    public static void main(String[] args) {
        String a = "1";
        String b = null;

        Date date = new Date();

        System.out.println( Objects.equals(a,b));
        System.out.println(a.equals(b));
    }
}