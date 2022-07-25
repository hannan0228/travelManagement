package com.travel.spring_aop.code;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	static final Logger LOGGER = LogManager.getLogger(Application.class.getName());

	public static void main(String[] args) {
		LOGGER.info("----------");
		SpringApplication.run(Application.class, args);
	}
}
