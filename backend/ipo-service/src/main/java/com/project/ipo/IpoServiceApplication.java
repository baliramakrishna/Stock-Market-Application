package com.project.ipo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class IpoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IpoServiceApplication.class, args);
	}

}
