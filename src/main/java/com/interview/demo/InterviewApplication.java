package com.interview.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.interview.demo.config.ServerConfig;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableConfigurationProperties(ServerConfig.class)
public class InterviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterviewApplication.class, args);
	}

}
