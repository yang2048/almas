package com.yyovo.adam.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages={"com.yyovo.adam.**"})
@SpringBootApplication
public class AdamApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdamApplication.class, args);
	}

}
