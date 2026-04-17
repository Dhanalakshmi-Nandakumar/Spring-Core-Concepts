package com.example.demo.config;

import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class AppConfig {
	
	@Bean
	Random getRandom()
	{
		log.info("****Creating a new Random bean");
		return new Random();
	}

}
