package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data //for getters and setters

public class user {
    @Id
    private int id;
    private String name;
    private String address;
}
