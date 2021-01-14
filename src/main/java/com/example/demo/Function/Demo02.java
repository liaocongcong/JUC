package com.example.demo.Function;

import java.util.function.Predicate;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2021/1/13 17:08
 */

/**
 * 断定型接口 ：有一个输入参数  返回值只能是 布尔类型
 */
public class Demo02 {
	public static void main(String[] args) {
		/*Predicate<String> predicate = new Predicate<String>() {
			@Override
			public boolean test(String o) {
				//if (o.isEmpty())
				return o.isEmpty();
			}
		};*/
		Predicate<String> predicate = (o)->{
			return o.isEmpty();
		};
		System.out.println(predicate.test(""));
	}
}
