package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2021/3/23 16:53
 */
public class testDate {
    public static void main(String[] args) {

// TODO Auto-generated method stub

        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");

        String dateString = "20071128175545";

        try {

            Date date = df.parse(dateString);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            String format = simpleDateFormat.format(date);
            System.out.println(format);

        } catch (Exception ex) {

            System.out.println(ex.getMessage());

        }

    }

}