package com.example.demo.JMM;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2021/1/15 10:45
 */
public class volatileDemo {

	private volatile static int num = 0;
	public static void main(String[] args) throws InterruptedException {


		new Thread(()->{
			while (num==0){

			}
		}).start();

		TimeUnit.SECONDS.sleep(1);
		num = 1;
		System.out.println(num);
	}

}
