package com.example.ch14.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name="product")
public class Product {
    //@NoArgs...가 의미하는 것은 기본생성자
    //@AllArgs..가 의미하는 것은 그 뭐냐 변수에 담는 생성자.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int stock;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
