package com.example.demo.Stream;

import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2021/1/14 14:39
 */
public class Test {

	public static void main(String[] args) {
		User u1 = new User(1,"a",21);
		User u2 = new User(2,"b",22);
		User u3 = new User(3,"c",23);
		User u4 = new User(4,"d",24);
		User u5 = new User(5,"e",25);
		
		//集合存储
		List<User> users = Arrays.asList(u1, u2, u3, u4, u5);
		users.stream().filter(user -> {return user.getId()%2==0;})
				.filter(user -> {return user.getAge()>23;})
				.map(user -> {return user.getName().toUpperCase(); })
				.sorted((uu1,uu2)->{return uu2.compareTo(uu1);})
				.limit(1)
				.forEach(System.out::println);
	}
}
