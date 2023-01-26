package com.example.multimodule.batch;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.multimodule")
@EntityScan(basePackages = "com.example.multimodule")
public class TestContext {
}
