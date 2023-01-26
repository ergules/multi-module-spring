package com.example.multimodule.library.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "DETAILED_USERS")
@Data
@EqualsAndHashCode(callSuper = true)
public class DetailedUser extends BaseEntity {

    private String firstname;
    private String lastname;
}
