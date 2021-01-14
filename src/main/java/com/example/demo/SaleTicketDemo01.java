package com.example.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2021/1/8 15:54
 */
public class SaleTicketDemo01 {
	public static void main(String[] args) {

		Ticket ticket = new Ticket();

		//多线程操作
		new Thread(()->{
			for (int i =1;i<60;i++){

				ticket.sale();
			}
		},"A").start();
		new Thread(()->{
			for (int i =1;i<60;i++){
				ticket.sale();
			}
		},"B").start();
		new Thread(()->{
			for (int i =1;i<60;i++){
				ticket.sale();
			}
		},"C").start();

	}
}

class Ticket{
	//属性  方法
	private int number = 50;

	Lock lock = new ReentrantLock();
	//卖出票
	public  void sale() {
		lock.lock();
		try {
			if (number>0){
				System.out.println(Thread.currentThread().getName()+"卖出了" +(number--)+"票，剩余"+number);
				sleep(2000);
			}
		}catch (InterruptedException e){
			e.printStackTrace();
		}finally {
			lock.unlock();
		}

	}

}
