package com.example.demo.FuHelp;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 信号量
 * @Author: liaocongcong
 * @Date: 2021/1/12 16:43
 */
public class TestSemaphore {
	public static void main(String[] args) {
     //线程数量  停车位 限流
		Semaphore semaphore = new Semaphore(3);

		for (int i = 1; i <= 6; i++) {
			new Thread(()->{
				try {
					semaphore.acquire();
					System.out.println(Thread.currentThread().getName()+"抢到车位");
					TimeUnit.SECONDS.sleep(2);
					System.out.println(Thread.currentThread().getName()+"离开车位");
				}catch (InterruptedException e){
					e.printStackTrace();
				}finally {
                 semaphore.release();
				}
			},String.valueOf(i)).start();
		}
	}
}
