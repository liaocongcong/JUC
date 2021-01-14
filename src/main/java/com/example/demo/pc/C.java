package com.example.demo.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:   精确通知消费者生产者案例
 * @Author: liaocongcong
 * @Date: 2021/1/11 14:21
 */
public class C {
	public static void main(String[] args) {
		Data3 data3 = new Data3();
		new Thread(()->{
			for (int i = 0; i < 10; i++) {
				data3.printA();
			}
		},"A").start();
		new Thread(()->{
			for (int i = 0; i < 10; i++) {
				data3.printB();
			}

		},"B").start();
		new Thread(()->{
			for (int i = 0; i < 10; i++) {
				data3.printC();
			}

		},"C").start();
	}
}

class Data3{
	//资源类
	private Lock lock = new ReentrantLock();

	private Condition condition1= lock.newCondition();
	private Condition condition2= lock.newCondition();
	private Condition condition3= lock.newCondition();

	private int number = 1;
	public void printA(){
     lock.lock();
     try {
     	while (number!=1){
     		condition1.await();
		}
		 System.out.println(Thread.currentThread().getName()+"=>AAAAAA");
     	 number = 2;
     	 condition2.signal();
	 }catch (Exception e){
     	e.printStackTrace();
	 }finally {
     	lock.unlock();
	 }
	}
	public void printB(){
		lock.lock();
		try {
			while (number!=2){
				condition2.await();
			}
			System.out.println(Thread.currentThread().getName()+"=>BBBBBB");
			number = 3;
			condition3.signal();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	public void printC(){

		lock.lock();
		try {
			while (number!=3){
				condition3.await();
			}
			System.out.println(Thread.currentThread().getName()+"=>CCCCC");
			number = 1;
			condition1.signal();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
}
