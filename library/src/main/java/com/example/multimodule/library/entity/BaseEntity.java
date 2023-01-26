package com.example.multimodule.library.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@MappedSuperclass
@Data
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant updatedAt;
    private Boolean deleted = false;

    @Version
    private Integer version;

    @PrePersist
    @PreUpdate
    public void preUpdate() {
        this.setUpdatedAt(Instant.now());
    }
}
