package com.example.db_practice.dto;

import java.time.LocalDateTime;

public class ChangeUserDto {
    private Long id;
    private String name;

    public ChangeUserDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ChangeUserDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
