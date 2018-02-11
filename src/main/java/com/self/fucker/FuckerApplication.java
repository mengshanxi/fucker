package com.self.fucker;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@MapperScan("com.self.fucker.mapper")
public class FuckerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuckerApplication.class, args);
	}
}
