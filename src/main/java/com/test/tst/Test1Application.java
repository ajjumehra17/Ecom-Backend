package com.test.tst;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Test1Application {

	public static void main(String[] args) {
		SpringApplication.run(Test1Application.class, args);
		System.out.println("Start...........");
	}
	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}
}
