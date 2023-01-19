package com.example.multimodule.library.db;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOM_MESSAGES")
@Data
@NoArgsConstructor
public class CustomMessage {
    @Id
    private Long id;

    private String message;

    public CustomMessage(Long id) {
        this.id = id;
    }

}
