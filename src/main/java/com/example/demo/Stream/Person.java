package com.example.demo.Stream;

import lombok.Data;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2021/1/26 11:15
 */
@Data
public class Person {
	private String name;  // 姓名
	private int salary; // 薪资
	private int age; // 年龄
	private String sex; //性别
	private String area;  // 地区

	// 构造方法
	public Person(String name, int salary, int age,String sex,String area) {
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.sex = sex;
		this.area = area;
	}


}
