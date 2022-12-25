package com.example.demo;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ReversProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReversProxyApplication.class, args);
	}

	@Bean
	public GroupedOpenApi ticketApi() {
		return GroupedOpenApi.builder().pathsToMatch("/tickets/**").group("tickets").build();
	}
}
