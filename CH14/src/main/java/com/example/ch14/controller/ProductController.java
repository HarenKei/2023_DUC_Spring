package com.example.ch14.controller;

import com.example.ch14.dto.ChangeProductDto;
import com.example.ch14.dto.ProductDto;
import com.example.ch14.dto.ProductResponseDto;
import com.example.ch14.entity.Product;
import com.example.ch14.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<ProductResponseDto> getProduct(Long number) {
        ProductResponseDto productResponseDto = productService.getProduct(number);
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @GetMapping("/byName")
    public ResponseEntity<List<ProductResponseDto>> getProductByName(String name) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductByName(name));
    }

    @GetMapping("/countByPrice")
    public ResponseEntity<Long> countByPrice(int price) {
        Long productResponseDto = productService.countByPrice(price);
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @GetMapping("/existsByNumber")
    public ResponseEntity<Boolean> existsByNumber(Long number) {
        boolean productResponseDto = productService.existsByNumber(number);
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @GetMapping("/byNameAndPrice")
    public ResponseEntity<ProductResponseDto> getProductByNameAndPrice(String name, int price) {
        ProductResponseDto productResponseDto = productService.getProductByNameAndPrice(name, price);
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @GetMapping("/listByPrice")
    public ResponseEntity<List<ProductResponseDto>> listProductByPrice() {
        List<ProductResponseDto> productResponseDto = productService.listProductByPrice();
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @GetMapping("/listByName")
    public ResponseEntity<List<ProductResponseDto>> listProductByName(String name) {
        List<ProductResponseDto> productResponseDto = productService.listProductByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @GetMapping("/listByStock")
    public ResponseEntity<List<ProductResponseDto>> listProductByStock(int stock) {
        List<ProductResponseDto> productResponseDto = productService.listByStock(stock);
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @PostMapping()
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductDto productDto) {
        ProductResponseDto productResponseDto = productService.saveProduct(productDto);
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @PutMapping()
    public ResponseEntity<ProductResponseDto> changeProductName(@RequestBody ChangeProductDto changeProductDto) throws Exception{
        ProductResponseDto productResponseDto = productService.changeProductName(changeProductDto.getNumber(), changeProductDto.getName());
        return ResponseEntity.status(HttpStatus.OK).body(productResponseDto);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteProduct(Long number) throws Exception{
        productService.deleteProduct(number);
        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }
}