package com.example.demo.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2021/1/11 14:42
 */
public class Test1 {


	public static void main(String[] args) {
		phone phone = new phone();
		new Thread(()->{
			phone.sendSms();
		},"A").start();

		try {
			TimeUnit.SECONDS.sleep(1);
		}catch (InterruptedException e){
			e.printStackTrace();
		}

		new Thread(()->{
			phone.call();
		},"A").start();
	}
}

class phone{
	/**
	 * synchronized 锁的对象是方法的调用者
	 * 两个方法用的是同一个锁，谁先调用先执行
	 *
	 */
	public synchronized void sendSms(){
		try {
			TimeUnit.SECONDS.sleep(4);
		}catch (InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("发短信");
	}

	public synchronized void call(){
		System.out.println("打电话");
	}
}