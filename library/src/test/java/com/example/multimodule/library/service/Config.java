package com.example.multimodule.library.service;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.multimodule")
@EntityScan(basePackages = "com.example.multimodule")
public class Config {
}
