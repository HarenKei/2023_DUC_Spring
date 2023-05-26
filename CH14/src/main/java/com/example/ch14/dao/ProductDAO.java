package com.example.ch14.dao;

import com.example.ch14.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductDAO {
    Product insertProduct(Product product);

    Product selectProduct(Long number);

    List<Product> selectProductByName(String name);

    Product selectProductByNameAndPrice(String name, int price);

    Long countByPrice(int price);

    List<Product> listProductByName(String name);

    List<Product> listProductByPrice();

    List<Product> listByStock(int stock);

    boolean existsByNumber(Long number);

    Product updateProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;
}
