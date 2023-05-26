package com.example.ch14.dto;

import com.example.ch14.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductResponseDto {
    private Long number;
    private String name;
    private int price;
    private int stock;

    public ProductResponseDto(Long number, String name, int price, int stock) {
        this.number = number;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public ProductResponseDto(Product product) {
        this.number = product.getNumber();
        this.name = product.getName();
        this.price = product.getPrice();
        this.stock = product.getStock();
    }
}
