package com.example.multimodule.library.db;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomMessageRepository extends JpaRepository<CustomMessage, Long> {
}
