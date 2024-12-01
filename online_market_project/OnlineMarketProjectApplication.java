package com.example.online_market_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class OnlineMarketProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineMarketProjectApplication.class, args);
	}

}
