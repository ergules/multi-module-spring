package com.example.multimodule.library.repository;

import com.example.multimodule.library.entity.DetailedUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailedUserRepository extends JpaRepository<DetailedUser, Long> {
}
