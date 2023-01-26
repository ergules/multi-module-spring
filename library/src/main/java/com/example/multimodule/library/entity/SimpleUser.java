package com.example.multimodule.library.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SIMPLE_USERS")
@Data
@EqualsAndHashCode(callSuper = true)
public class SimpleUser extends BaseEntity {

    private String name;
}
