package com.example.demo.JucList;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2021/1/12 15:20
 */
public class TestMap {
	public static void main(String[] args) {

		Map<String ,String> map = new ConcurrentHashMap<>() ;
		for (int i = 0; i < 30; i++) {
			new Thread(()->{
				map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,5));
				System.out.println(map);
			},String.valueOf(i)).start();
		}
	}
}
