package com.calm.study.web_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class App {
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(new Object[] { App.class });
		application.run(args);
	}

}
