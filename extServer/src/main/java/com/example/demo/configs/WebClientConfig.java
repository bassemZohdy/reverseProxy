package com.example.demo.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;


@Configuration(proxyBeanMethods = false)
public class WebClientConfig {

    @Bean
    public WebClient webClient(){
        return WebClient.builder().baseUrl("http://localhost:3000").clientConnector(
                new ReactorClientHttpConnector(
                        HttpClient.create().proxyWithSystemProperties())).build();
    }
}
