package com.devsuperior.dscatalog.repositories;


import com.devsuperior.dscatalog.entities.Product;
import com.devsuperior.dscatalog.tests.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

@DataJpaTest
public class ProductRepositoryTests {

    @Autowired
    private ProductRepository productRepository;

    private long expectedId;
    private long nonExistingId;
    private long lastId;

    @BeforeEach
    void setUp() throws Exception {
        expectedId = 1l;
        nonExistingId = 1000L;
        lastId = 25;
    }

    @Test
    public void saveShouldPersistWithAutroincrementWhenIdIsNull() {
        Product product = Factory.createProduct();
        product.setId(null);
        product = productRepository.save(product);
        Assertions.assertNotNull(product.getId());
        Assertions.assertEquals(lastId + 1, product.getId());
    }

    @Test
    public void deleteShouldDeleteObjectWhenIdExists() {
        productRepository.deleteById(expectedId);
        Optional<Product> result = productRepository.findById(expectedId);
        Assertions.assertFalse(result.isPresent());
    }

    @Test
    public void deleteShouldThrowEmptyResultDataAccessExceptionWhenIdDoesNotExist() {
        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
            productRepository.deleteById(nonExistingId);
        });
    }

    @Test
    public void findByIdShouldReturnOptionalOfProductNotEmptyWhenIdExist() {
        Optional<Product> result = productRepository.findById(expectedId);
        Assertions.assertTrue(result.isPresent());
     }

    @Test
    public void findByIdShouldReturnOptionalOfProductEmptyWhenIdExist() {
        Optional<Product> result = productRepository.findById(nonExistingId);
        Assertions.assertTrue(result.isEmpty());
     }

}
