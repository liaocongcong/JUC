package com.example.demo.pool;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2021/1/13 15:52
 */

import java.util.concurrent.*;

/**
 * Executors  工具类   三大方法
 */
public class Demo01 {

	public static void main(String[] args) {

		System.out.println(Runtime.getRuntime().availableProcessors());
		ExecutorService executorService = new ThreadPoolExecutor(2,
				5,
				3,
				TimeUnit.SECONDS,
				new LinkedBlockingQueue<>(3),
				Executors.defaultThreadFactory(),
				new ThreadPoolExecutor.DiscardPolicy());  //银行满了  还有人进来  不处理这个人
		//ExecutorService executorService = Executors.newSingleThreadExecutor();//单个线程
		//ExecutorService executorService=Executors.newFixedThreadPool(5);  //创建一个固定的线程池的大小
		//ExecutorService executorService=Executors.newCachedThreadPool();  //可伸缩
		try {
			for (int i = 1; i <= 10; i++) {
				executorService.execute(()->{
					System.out.println(Thread.currentThread().getName()+ " OK");
				});
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			//程序结束  关闭线程池
			executorService.shutdown();
		}
	}
}
