package com.example.demo.Function;

import java.util.function.Function;

/**
 * @Description:  函数型接口  Fuction 有一个输入参数，有一个输出
 * @Author: liaocongcong
 * @Date: 2021/1/13 16:58
 */
public class Demo01 {
	public static void main(String[] args) {

		/*Function function= new Function<String,String>() {
			@Override
			public String apply(String o) {
				return o;
			}
		};*/
		/*Function function = (str)->{str;
		};*/
		Function<String,String > function = str->{
			return str;
		};
		System.out.println(function.apply("888"));
	}
}
