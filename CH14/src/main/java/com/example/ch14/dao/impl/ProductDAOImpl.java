package com.example.ch14.dao.impl;

import com.example.ch14.dao.ProductDAO;
import com.example.ch14.entity.Product;
import com.example.ch14.repository.ProductRepository;
import com.example.ch14.repository.QProductRepository;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.example.ch14.entity.QProduct.product;

@Component
public class ProductDAOImpl implements ProductDAO {
    private final ProductRepository productRepository;
    private final QProductRepository qProductRepository;
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Product> allProduct() {
        return jpaQueryFactory.selectFrom(product).where(product.name.eq("abcd")).orderBy(product.price.desc()).fetch();
    }

    @Autowired
    public ProductDAOImpl(ProductRepository productRepository, QProductRepository qProductRepository, JPAQueryFactory jpaQueryFactory) {
        this.productRepository = productRepository;
        this.qProductRepository = qProductRepository;
        this.jpaQueryFactory = jpaQueryFactory;
    }
    @Override
    public Product insertProduct(Product product) {
        Product saveProduct = productRepository.save(product);
        return saveProduct;
    }

    @Override
    public Product selectProduct(Long number) {
//        Product selectProduct = productRepository.getReferenceById(number);
//        return selectProduct;

        Predicate predicate = product.number.eq(number);
        Optional<Product> selectProduct = qProductRepository.findOne(predicate);

        return selectProduct.isPresent() ? selectProduct.get() : null;
    }

    @Override
    public List<Product> selectProductByName(String name) {
        List<Product> selectProduct = productRepository.findByName(name, Sort.by(Sort.Order.asc("price")));
        return selectProduct;
    }

    @Override
    public Product selectProductByNameAndPrice(String name, int price) {
        Product selectProduct = productRepository.findByNameAndPrice(name, price);
        return selectProduct;
    }

    @Override
    public Long countByPrice(int price) {
        return productRepository.countByPrice(price);
    }

    @Override
    public boolean existsByNumber(Long number) {
        return productRepository.existsByNumber(number);
    }

    @Override
    public List<Product> listProductByName(String name) {
        return productRepository.findByNameOrderByPriceDesc(name);
    }

    @Override
    public List<Product> listProductByPrice() {
        return productRepository.findAllByOrderByPriceAsc();
    }

    @Override
    public List<Product> listByStock(int stock) {
        return productRepository.listByStock(stock);
    }

    @Override
    public Product updateProductName(Long number, String name) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);
        Product updateProduct;

        if(selectedProduct.isPresent()) {
            Product product = selectedProduct.get();
            product.setName(name);
            product.setUpdatedAt(LocalDateTime.now());

            updateProduct = productRepository.save(product);
        } else throw new Exception();

        return updateProduct;
    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);

        if(selectedProduct.isPresent()) {
            Product product = selectedProduct.get();
            productRepository.delete(product);
        } else throw new Exception();
    }
}
