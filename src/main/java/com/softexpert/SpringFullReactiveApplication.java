package com.softexpert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan("com")
@EnableWebMvc
@EnableAutoConfiguration
public class SpringFullReactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFullReactiveApplication.class, args);
	}
}
