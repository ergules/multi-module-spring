package com.example.multimodule.application;

import com.example.multimodule.library.service.MyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication(scanBasePackages = "com.example.multimodule")
@EnableJpaRepositories(basePackages = "com.example.multimodule")
@EntityScan(basePackages = "com.example.multimodule")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
