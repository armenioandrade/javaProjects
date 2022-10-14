package com.springsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class SpringSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSystemApplication.class, args);
                   System.out.println("Spring app up and ready!");
	}

}
