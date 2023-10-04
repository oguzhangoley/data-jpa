package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class QueryMethodsTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod() {
        Product product = productRepository.findByName("product 2");
        System.out.println(product.toString());
    }

    @Test
    void findByIdMethod() {
        Optional<Product> product = productRepository.findById(6L);
        System.out.println(product.isEmpty() ? "product not found" : product.get().toString());
    }

    @Test
    void findByNameOrDescriptionMethod(){
        List<Product> productList = productRepository.findByNameOrDescription("product 2","product 3 description");
        productList.forEach(p-> System.out.println(p.toString()));
    }

    @Test
    void findByNameAndDescriptionMethod(){
        List<Product> productList = productRepository.findByNameAndDescription("product 2","product 2 description");
        productList.forEach(p-> System.out.println(p.toString()));
    }

    @Test
    void findDistinctByNameMethod() {
        Product product = productRepository.findDistinctByName("product 2");
        System.out.println(product.toString());
    }
}
