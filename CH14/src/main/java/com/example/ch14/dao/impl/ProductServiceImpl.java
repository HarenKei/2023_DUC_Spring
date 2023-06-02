package com.example.ch14.dao.impl;

import com.example.ch14.dao.ProductDAO;
import com.example.ch14.dto.ProductDto;
import com.example.ch14.dto.ProductResponseDto;
import com.example.ch14.entity.Product;
import com.example.ch14.service.ProductService;
import org.hibernate.query.criteria.JpaRoot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.EntityResponse;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;



    @Autowired
    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public ProductResponseDto getProduct(Long number) {
        Product product = productDAO.selectProduct(number);
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setName(product.getName());
        productResponseDto.setNumber(product.getNumber());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setStock(product.getStock());

        return productResponseDto;
    }



    @Override
    public List<ProductResponseDto> getProductByName(String name) {
        List<Product> product = productDAO.selectProductByName(name);
        List<ProductResponseDto> productResponseDtoList = product.stream().map(ProductResponseDto::new).collect(Collectors.toList());
        return productResponseDtoList;
    }

    @Override
    public List<ProductResponseDto> listByStock(int stock) {
        List<Product> product = productDAO.listByStock(stock);
        List<ProductResponseDto> productResponseDtoList = product.stream().map(ProductResponseDto::new).collect(Collectors.toList());
        return productResponseDtoList;
    }

    @Override
    public ProductResponseDto saveProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        Product saveProduct = productDAO.insertProduct(product);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setName(saveProduct.getName());
        productResponseDto.setNumber(saveProduct.getNumber());
        productResponseDto.setPrice(saveProduct.getPrice());
        productResponseDto.setStock(saveProduct.getStock());

        return productResponseDto;
    }


    @Override
    public Long countByPrice(int price) {
        return productDAO.countByPrice(price);
    }

    @Override
    public boolean existsByNumber(Long number) {
        return productDAO.existsByNumber(number);
    }

    @Override
    public ProductResponseDto getProductByNameAndPrice(String name, int price) {
        Product product = productDAO.selectProductByNameAndPrice(name, price);
        return new ProductResponseDto(product);
    }

    @Override
    public List<ProductResponseDto> listProductByName(String name) {
        List<Product> products= productDAO.listProductByName(name);
        List<ProductResponseDto> productResponseDtoList = products.stream().map(ProductResponseDto::new).collect(Collectors.toList());
        return productResponseDtoList;
    }

    @Override
    public List<ProductResponseDto> list() {
        List<Product> products = productDAO.listProductByPrice();
        List<ProductResponseDto> productResponseDtoList = products.stream().map(ProductResponseDto::new).collect(Collectors.toList());
        return productResponseDtoList;
    }

    @Override
    public List<ProductResponseDto> allProduct() {
        List<Product> products = productDAO.allProduct();
        List<ProductResponseDto> productResponseDtoList = products.stream().map(ProductResponseDto::new).collect(Collectors.toList());
        return productResponseDtoList;
    }

    @Override
    public ProductResponseDto changeProductName(Long number, String name) throws Exception{
        Product changeProduct = productDAO.updateProductName(number, name);

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setName(changeProduct.getName());
        productResponseDto.setNumber(changeProduct.getNumber());
        productResponseDto.setPrice(changeProduct.getPrice());
        productResponseDto.setStock(changeProduct.getStock());

        return productResponseDto;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        productDAO.deleteProduct(number);
    }
}
