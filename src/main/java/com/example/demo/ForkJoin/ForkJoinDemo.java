package com.example.demo.ForkJoin;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.OptionalLong;
import java.util.stream.LongStream;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2021/1/14 15:21
 */
public class ForkJoinDemo {

	private  Long start;
	private  Long end;

	//临界值
	private Long temp = 10000L;


	public ForkJoinDemo(Long start, Long end) {
		this.start = start;
		this.end = end;
	}


	@Test
	public void testStream() {
		Instant start = Instant.now();
		//使用StreamAPI
		OptionalLong result = LongStream.rangeClosed(0L, 50000000000L)
				.parallel()
				.reduce(Long::sum);
		System.out.println(result.getAsLong());
		Instant end = Instant.now();
		System.out.println("五百亿求和耗费的时间为: " + Duration.between(start, end).toMillis());
	}
}
