package com.form.adminform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class AdminformApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminformApplication.class, args);
	}

}
