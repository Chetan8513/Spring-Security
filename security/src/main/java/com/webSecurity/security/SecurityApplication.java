package com.webSecurity.security;

import org.apache.catalina.core.ApplicationFilterConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);

//		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationFilterConfig.class);
//
//	String[]names = 	applicationContext.getBeanDefinitionNames();
//
//
//		Arrays.stream(names).forEach(System.out::println);
	}




}
