package com.example.demo.lock8;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2021/1/11 14:42
 */
public class Test2 {


	public static void main(String[] args) {
		//Set<String> strings = Collections.synchronizedSet()
		Set<String> strings = new CopyOnWriteArraySet<>();
		//strings.add()
		phone2 phone = new phone2();
		new Thread(()->{
			phone.sendSms();
		},"A").start();

		try {
			TimeUnit.SECONDS.sleep(1);
		}catch (InterruptedException e){
			e.printStackTrace();
		}

		new Thread(()->{
			phone.hello();
		},"B").start();
	}
}

class phone2{

	//List<String> list= new CopyOnWriteArrayList<>();

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

	//不受锁的影响，不是同步方法
	public void hello(){
		System.out.println("hello!");
	}
}