package com.junit.day1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day1Application {

	public static void main(String[] args) {
		SpringApplication.run(Day1Application.class, args);
		System.out.println("Hello, JUnit Day 1!");
		System.out.println("Welcome to the world of testing with JUnit!");
	}

}
