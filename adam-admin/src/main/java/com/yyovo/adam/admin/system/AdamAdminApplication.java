package com.yyovo.adam.admin.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@ComponentScan(basePackages={"com.yyovo.adam.**"})
public class AdamAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdamAdminApplication.class, args);
    }

}
