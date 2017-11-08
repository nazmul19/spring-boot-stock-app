package com.rds.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.rds.stock")
@SpringBootApplication
public class RdsStockApplication {

	public static void main(String[] args) {
		SpringApplication.run(RdsStockApplication.class, args);
	}
}
