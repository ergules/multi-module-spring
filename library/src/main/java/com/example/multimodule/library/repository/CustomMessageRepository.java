package com.example.multimodule.library.repository;

import com.example.multimodule.library.entity.CustomMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomMessageRepository extends JpaRepository<CustomMessage, Long> {
}
