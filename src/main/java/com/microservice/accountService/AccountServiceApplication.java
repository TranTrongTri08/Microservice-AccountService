package com.microservice.accountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
public class AccountServiceApplication implements CommandLineRunner {
	
	@Autowired
	private Environment environment;
	
	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(environment.getProperty("player.striker.name"));
	}

}
