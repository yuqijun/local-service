package com.yuqijun.localservice.store;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.yuqijun.localservice.store.dao")
@SpringBootApplication
public class LocalServiceStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocalServiceStoreApplication.class, args);
	}

}
