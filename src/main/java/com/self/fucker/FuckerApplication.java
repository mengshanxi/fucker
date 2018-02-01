package com.self.fucker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class FuckerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuckerApplication.class, args);
	}
}
