package com.hackaton.foodforall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FoodforallApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/FoodForAll");
		SpringApplication.run(FoodforallApplication.class, args);
	}

}
