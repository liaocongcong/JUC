package com.example.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2021/1/8 16:29
 */
public class SaleTicketDemo02 {
	public static void main(String[] args) {

		Ticket01 ticket = new Ticket01();

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

class Ticket01{

	/**
	 *  public ReentrantLock() {
	 *         sync = new NonfairSync();
	 *     }
	 *
	 *     /**
	 *      * Creates an instance of {@code ReentrantLock} with the
	 *      * given fairness policy.
	 *      *
	 *      * @param fair {@code true} if this lock should use a fair ordering policy
	 *     public ReentrantLock(boolean fair) {
	 * 	 *sync = fair ? new FairSync() : new NonfairSync();
	 * 	 *}
	 *

			 */

	/**
	 * 公平锁
	 * 非公平锁
	 */

	//属性  方法
	private int number = 50;

	Lock lock = new ReentrantLock();
	//卖出票
	public void sale(){
		lock.lock();//加锁

		try {
			if (number>0){
				System.out.println(Thread.currentThread().getName()+"卖出了" +(number--)+"票，剩余"+number);
			}
		}finally {
			lock.unlock();//解锁
		}

	}

}
