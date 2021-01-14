package com.example.demo.Function;

import java.util.function.Supplier;

/**
 * @Description:  Supplier 供给型接口 没有返回值
 * @Author: liaocongcong
 * @Date: 2021/1/13 17:21
 */
public class Demo04 {
	public static void main(String[] args) {
		/*Supplier<String> stringSupplier = new Supplier<String>() {
			@Override
			public String get() {
				return "聪聪";
			}
		};*/

		Supplier<String> stringSupplier =()->{
		return "555";
		};

		System.out.println(stringSupplier.get());
	}
}
