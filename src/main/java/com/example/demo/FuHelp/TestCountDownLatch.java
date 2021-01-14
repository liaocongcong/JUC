package com.example.demo.FuHelp;

import java.util.concurrent.CountDownLatch;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2021/1/12 16:42
 */

//计数器
public class TestCountDownLatch {
	public static void main(String[] args) throws InterruptedException {
		//总数是6 必须执行完任务才执行  再使用
		CountDownLatch countDownLatch = new CountDownLatch(6);
		for (int i = 1; i <= 6; i++) {
			new Thread(()->{
				System.out.println(Thread.currentThread().getName()+"Go out");
				countDownLatch.countDown(); //数量 - 1
			},String.valueOf(i)).start();
		}
		countDownLatch.await();//等待计数器归零，然后再向下执行
		System.out.println("Close door");
	}
}
