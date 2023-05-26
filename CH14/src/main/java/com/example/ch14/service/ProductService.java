package com.example.ch14.service;

import com.example.ch14.dto.ProductDto;
import com.example.ch14.dto.ProductResponseDto;
import com.example.ch14.entity.Product;

import java.util.List;

public interface ProductService {

    ProductResponseDto getProduct(Long number);

    List<ProductResponseDto> getProductByName(String name);

    ProductResponseDto saveProduct(ProductDto productDto);

    ProductResponseDto getProductByNameAndPrice(String name, int price);

    List<ProductResponseDto> listProductByName(String name);

    List<ProductResponseDto> listProductByPrice();

    List<ProductResponseDto> listByStock(int stock);

    Long countByPrice(int price);

    boolean existsByNumber(Long number);

    ProductResponseDto changeProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;
}