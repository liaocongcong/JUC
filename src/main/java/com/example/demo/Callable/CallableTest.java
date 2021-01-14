package com.example.demo.Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2021/1/12 15:49
 */
public class CallableTest {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		//Runnable
        new Thread().start();
        MyThread myThread = new MyThread();
		FutureTask futureTask = new FutureTask(myThread);
		new Thread(futureTask,"A").start();
		new Thread(futureTask,"B").start();
		Integer o = (Integer) futureTask.get();
		System.out.println(o);
	}
}

class MyThread implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		System.out.println("call()");
		return 1024;
	}
}
