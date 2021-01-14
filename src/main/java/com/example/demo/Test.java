package com.example.demo;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2021/1/8 15:02
 */
public class Test {

	public static void main(String[] args) {
		//new Thread().start();获取cpu运行核数
		System.out.println(Runtime.getRuntime().availableProcessors());
		//Thread.State  运行时状态
		/**
		 * wait  会释放锁  必须在同步代码块
		 *
		 * sleep  抱着锁  不会释放
		 */
	}
}
