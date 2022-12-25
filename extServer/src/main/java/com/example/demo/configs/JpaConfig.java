package com.example.demo.configs;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration(proxyBeanMethods = false)
@ConditionalOnProperty(prefix = "jpa", name = "enabled")
@EnableJpaAuditing
public class JpaConfig {
}
