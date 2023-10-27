package com.paloit.demo.commontemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CommonTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommonTemplateApplication.class, args);
	}

}
