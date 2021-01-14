package com.example.demo.FuHelp;

import com.example.demo.pc.C;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2021/1/12 16:42
 */
public class TestCycliBarrier {
	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
			System.out.println("测试成功！");
		});
		for (int i = 1; i <= 7; i++) {
			final int temp = i;
			new Thread(()->{
				System.out.println(Thread.currentThread().getName()+"收集"+temp+"灵魂");
				try {
					cyclicBarrier.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
			}).start();
		}
	}
}
