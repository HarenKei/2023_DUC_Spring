package com.example.ch14.repository;

import com.example.ch14.entity.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByName(String name, Sort sort);
    Long countByPrice(int price);
    boolean existsByNumber(Long number);
    Product findByNameAndPrice(String name, int price);
    List<Product> findByNameOrderByPriceDesc(String name);
    List<Product> findAllByOrderByPriceAsc();

    @Query("SELECT p FROM Product AS p WHERE p.stock = :stock")
    //@Query 어노테이션을 통한 쿼리
    //?은 파라미터를 받기 위한 인자고 ?1은 첫번째 파라미터를 의미한다.
    List<Product> listByStock(@Param("stock") int stock);
}
