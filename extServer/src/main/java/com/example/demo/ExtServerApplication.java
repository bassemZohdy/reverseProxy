package com.example.demo;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class ExtServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExtServerApplication.class, args);
	}

	@Bean
	public GroupedOpenApi ticketApi() {
		return GroupedOpenApi.builder().pathsToMatch("/tickets/**").group("tickets").build();
	}
}
