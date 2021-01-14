package com.example.demo.rw;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2021/1/13 14:00
 */
public class ReadWruterLokDemo {

	public static void main(String[] args) {
		MyCache myCache = new MyCache();
		for (int i = 1; i <= 10; i++) {
			final int temp =i;
			new Thread(()->{
				myCache.put(temp+"",temp);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			},String.valueOf(i)).start();
		}

		for (int i = 1; i <= 10; i++) {
			final int temp =i;
			new Thread(()->{
				myCache.get(temp+"");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			},String.valueOf(i)).start();
		}
	}

}

/**
 * 自定义缓存
 */
class MyCache{

	private volatile Map<String,Object> map = new HashMap<>();

	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	/**
	 * 写入
	 * @param key
	 * @param value
	 */
	public void put(String key,Object value){
		readWriteLock.writeLock().lock();
		try {
			System.out.println(Thread.currentThread().getName()+"写入"+key);
			map.put(key,value);
			System.out.println(Thread.currentThread().getName()+"写入OK"+key);
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			readWriteLock.writeLock().unlock();
		}

	}

	/**
	 * 读取
	 * @param key
	 */
	public void get(String key){
		readWriteLock.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName()+"读取"+key);
			Object o= map.get(key);
			System.out.println(Thread.currentThread().getName()+"读取OK"+key);
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			readWriteLock.readLock().unlock();
		}
	}
}
