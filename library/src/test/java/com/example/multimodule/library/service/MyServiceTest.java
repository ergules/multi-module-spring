package com.example.multimodule.library.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.multimodule.library.db.CustomMessage;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityManager;

@SpringBootTest
@Import(Config.class)
@PropertySource("classpath:mm-library-test.properties")
public class MyServiceTest {

	@Autowired
	private MyService myService;

	@Autowired
	EntityManager manager;

	@Test
	public void contextLoads() {
		assertThat(myService.message()).isNotNull();
	}

	@Test
	public void whenCustomMessageUpdatedReturnNew() {
		String newMessage = "new-message";
		myService.saveCustom(newMessage);

		CustomMessage msg = manager.find(CustomMessage.class, 1L);
		assertThat(msg.getMessage()).isEqualTo(newMessage);
	}

	@SpringBootApplication
	static class TestConfiguration {
	}

}
