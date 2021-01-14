package com.example.demo.bq;

import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2021/1/13 14:42
 */
public class Test {

	public static void main(String[] args) {
		//BlockingQueue blockingQueue  :多线程并发  线程池
        test1();
	}

	/**
	 *
	 *抛出异常
	 */

	public static void test1(){
		ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue(3);
		System.out.println(blockingQueue.add(5));
		System.out.println(blockingQueue.add(5));
		System.out.println(blockingQueue.add(5));
		//System.out.println(blockingQueue.add(5));
	}
}
