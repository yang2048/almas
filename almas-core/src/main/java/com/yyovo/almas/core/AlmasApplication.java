package com.yyovo.almas.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages={"com.yyovo.almas.**"})
@SpringBootApplication
public class AlmasApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlmasApplication.class, args);
	}

}
