package com.example.demo.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Description:  异步调用
 * @Author: liaocongcong
 * @Date: 2021/1/14 16:16
 */
public class Demo01 {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		//CompletableFuture<Integer> completableFuture  =CompletableFuture.runAsync()

		//发起一个请求  无返回值
		CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"888888");
		});
		System.out.println("1111111111");
		completableFuture.get();

		//completableFuture.all


	}
}
