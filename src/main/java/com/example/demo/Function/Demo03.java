package com.example.demo.Function;

import java.util.function.Consumer;

/**
 * @Description:  consumer 消费型接口  只有输入  没有返回值
 *
 *                Suppeir
 * @Author: liaocongcong
 * @Date: 2021/1/13 17:16
 */
public class Demo03 {

	public static void main(String[] args) {
	/*	Consumer<String> consumer = new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println(s);
			}
		};*/
		Consumer<String> consumer =(s)->{
			System.out.println(s);
		};
		consumer.accept("555");
	}
}
