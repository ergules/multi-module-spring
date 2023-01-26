package com.example.multimodule.library.repository;

import com.example.multimodule.library.entity.SimpleUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimpleUserRepository extends JpaRepository<SimpleUser, Long> {
}
