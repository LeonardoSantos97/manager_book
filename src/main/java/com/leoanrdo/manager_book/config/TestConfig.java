package com.leoanrdo.manager_book.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.leoanrdo.manager_book.services.DBService;

@Configuration
@Profile("teste")
public class TestConfig {

	@Autowired
	private DBService dbService;
	
	@Bean
	public void instaciaDB() {
		this.dbService.instaciaDB();
	}
}
