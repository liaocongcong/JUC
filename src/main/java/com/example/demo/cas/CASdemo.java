package com.example.demo.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description:   CAS  比较当前工作内存中的值和主内存的值，如果这个值是期望值，那么则执行操作
 * @Author: liaocongcong
 * @Date: 2021/1/15 15:40
 */
public class CASdemo {

	//cas
	public static void main(String[] args) {

		AtomicInteger atomicInteger = new AtomicInteger(2020);

		//如果我的期望值达到了，那么就更新，否则，就不跟新  cas 是cpu的并发原语
		System.out.println(atomicInteger.compareAndSet(2020, 2021));
		System.out.println(atomicInteger.get());
		atomicInteger.getAndIncrement();

		System.out.println(atomicInteger.compareAndSet(2020, 2021));
		System.out.println(atomicInteger.get());
	}
}
