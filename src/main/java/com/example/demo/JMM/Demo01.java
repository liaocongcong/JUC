package com.example.demo.JMM;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2021/1/14 18:01
 */
public class Demo01 {
	/**
	 * Volatile 是java虚拟机提供轻量级的同步机制
	 *
	 * 1.保证可见性
	 * 2.不保证原子性 ☆
	 * 3.禁止指令重排
	 */

	/**
	 * JMM  java内存模型 不存在的东西  概念  约定
	 *
	 * 1.线程解锁前  必须把共享变量立刻刷回主内存
	 * 2.线程枷锁前  必须把读取主存中的最新值到工作内存中
	 * 3.加锁和解锁必须是同一把锁
	 */
}
