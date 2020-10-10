package com.yyovo.almas.admin.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
//@ComponentScan(basePackages={"com.yyovo.almas.**"})
public class AlmasAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlmasAdminApplication.class, args);
	}

}
