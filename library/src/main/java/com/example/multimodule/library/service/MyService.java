package com.example.multimodule.library.service;

import com.example.multimodule.library.db.CustomMessage;
import com.example.multimodule.library.db.CustomMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@EnableConfigurationProperties(ServiceProperties.class)
@RequiredArgsConstructor
public class MyService {

	private final ServiceProperties serviceProperties;
	private final CustomMessageRepository repository;

	public String message() {
		return this.serviceProperties.getMessage();
	}

	public void saveCustom(String msg) {
		CustomMessage message = repository.findById(1L).orElse(new CustomMessage(1L));
		message.setMessage(msg);
		repository.save(message);
	}

	public String getCustom() {
		CustomMessage message = repository.findAll().get(0);
		return message.getMessage();
	}
}
