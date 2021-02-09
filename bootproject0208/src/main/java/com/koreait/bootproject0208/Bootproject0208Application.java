package com.koreait.bootproject0208;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.koreait.bootproject0208.test.Dog;

@SpringBootApplication
public class Bootproject0208Application {

	public static void main(String[] args) {
		SpringApplication.run(Bootproject0208Application.class, args);
	}
	
	@Bean
	public Dog dog() {
		return new Dog();
	}
	
}
