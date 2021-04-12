package com.example.demo;



import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2021/4/8 17:41
 */
public class Test2 {

    public static void main(String[] args) {
       /* System.out.println(toChinese(62284));

        //System.out.println((char)48);
        //StringUtils.substringBeforeLast
        String tf = "278.090";
       // double e = 78.09;
        String a =null;
        String[] split = tf.split("\\.");
        System.out.println(Integer.parseInt(split[0]));
        System.out.println(Integer.parseInt(split[1].substring(0,split[1].lastIndexOf("0"))));
        System.out.println(!StringUtils.isEmpty(a));
        System.out.println("k".equals(a));*/

        List<Person> personList = new ArrayList<>();

        Person p  = new Person("jj");
        Person p1 =  new Person();
        Person p2 =  new Person("oo");
        Person p3 =  new Person("");

        //personList.add(p);
      // personList.add(p1);
       // personList.add(p2);
       personList.add(p3);
        System.out.println(testy(personList));
        //System.out.println(!StringUtils.isEmpty(p1.getName()));
        if (p1 ==null){
            System.out.println("000");
        }
    }

    private static StringBuffer toChinese(int str) {
        String[] s1 = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        StringBuffer str1 = new StringBuffer();
        int[] toarry = toarry(str);
        for (int i =0;i<toarry.length;i++){
            str1.append(s1[toarry[i]]);
        }
        return str1;
    }

    private static int[] toarry(int num){
        String nums = String.valueOf(num);
        int[] result = new int[nums.length()];
        for (int i =0;i<nums.length();i++){
            result[i] = Integer.parseInt(String.valueOf(nums.charAt(i)));
        }
        return result;
    }

    private  static  boolean testy(List<Person> personList){
        boolean flag = false;
        for (Person person:personList){
            if (!StringUtils.isEmpty(person.getName())){
                flag= true;
            }else {
                flag= false;
            }
        }
       return flag;
    }
}