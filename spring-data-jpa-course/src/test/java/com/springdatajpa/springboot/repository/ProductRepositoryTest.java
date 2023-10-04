package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod() {
        //create product
        Product product = new Product();
        product.setName("product 1");
        product.setDescription("product 1 description");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("product1.png");
        //save product
        Product savedProduct = productRepository.save(product);
        //display product info
        System.out.println(savedProduct.getId());
        System.out.println(savedProduct.toString());
    }

    @Test
    void updateUsingSaveMethod() {
        Long id = 1L;
        Product product = productRepository.findById(id).get();
        product.setName("updated product 1");
        product.setDescription("updated product 1 description");
        productRepository.save(product);

    }

    @Test
    void findByIdMethod() {
        Long id = 1L;
        Product product = productRepository.findById(id).get();
    }

    @Test
    void saveAllMethod() {
        Product product = new Product();
        product.setName("product 2");
        product.setDescription("product 2 description");
        product.setSku("100ABCD");
        product.setPrice(new BigDecimal(200));
        product.setActive(true);
        product.setImageUrl("product2.png");

        Product product3 = new Product();
        product3.setName("product 3");
        product3.setDescription("product 3 description");
        product3.setSku("100ABCDE");
        product3.setPrice(new BigDecimal(300));
        product3.setActive(true);
        product3.setImageUrl("product3.png");

        productRepository.saveAll(List.of(product, product3));
    }

    @Test
    void findAllMethod() {
        List<Product> products = productRepository.findAll();

        products.forEach((p) -> {
            System.out.println(p.toString());
        });
    }

    @Test
    void deleteById() {
        Long id = 1L;
        productRepository.deleteById(id);
    }

    @Test
    void deleteMethod() {
        Long id = 4L;
        Product product = productRepository.findById(id).get();

        productRepository.delete(product);

    }

    @Test
    void deleteAllMethod() {
        productRepository.deleteAll();
    }

    @Test
    void countMethod(){
        Long count = productRepository.count();
        System.out.println(count);
    }

    @Test
    void existByIdMethod(){
        Long id = 5L;
        boolean exists = productRepository.existsById(id);
        System.out.println("5 : "+exists);
        boolean falseExists = productRepository.existsById(1L);
        System.out.println("1 : " +falseExists);
    }
}