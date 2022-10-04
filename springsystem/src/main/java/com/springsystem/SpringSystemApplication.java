package com.springsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSystemApplication.class, args);
                   System.out.println("Spring app up and ready");
	}

}
