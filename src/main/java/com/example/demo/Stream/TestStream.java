package com.example.demo.Stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2021/1/26 9:55
 */
public class TestStream {


	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);

		//遍历出符合条件的元素
		list.stream().filter(x->x>6).forEach(System.out::println);

		//匹配的第一个
		Optional<Integer> findFirst = list.stream().filter(x -> x > 6).findFirst();

		//匹配任意的
		Optional<Integer> findAny = list.parallelStream().filter(x -> x > 6).findAny();
		
		//是否包含符合特定条件的元素
		boolean anyMatch = list.stream().anyMatch(x -> x < 6);

		System.out.println("匹配第一个值：" + findFirst.get());
		System.out.println("匹配任意一个值：" + findAny.get());
		System.out.println("是否存在大于6的值：" + anyMatch);

	}



	List<String> list = Arrays.asList("a","b","c");

	Stream<String> stream = list.stream();

	Stream<String> p = list.parallelStream();

	int[] array = {1,2,3,4,6};
    IntStream streams= Arrays.stream(array);

    @Test
	public void testStream(){

		List<Person> personList = new ArrayList<Person>();

		personList.add(new Person("Tom", 8900, 23, "male", "New York"));
		personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
		personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
		personList.add(new Person("Anni", 8200, 24, "female", "New York"));
		personList.add(new Person("Owen", 9500, 25, "male", "New York"));
		personList.add(new Person("Alisa", 7900, 26, "female", "New York"));

    	Stream<Integer> stream = Stream.of(1,9,3,4,5,6,7);
    	Stream<Integer> stream1 = Stream.iterate(2,(x)->x+3).limit(4);
    	stream1.forEach(System.out::println);

    	Stream<Double> stream2  = Stream.generate(Math::random).limit(3);
    	stream2.forEach(System.out::println);


    	//筛选出工资高于8000的人，并行成一个新的集合
		List<String> collect = personList.stream().filter(x -> x.getSalary() > 8000).map(Person::getName).collect(Collectors.toList());

		System.out.print("高于8000的员工姓名：" + collect);

	}


}
