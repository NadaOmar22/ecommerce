package com.practice.ecommerce.service;

import com.practice.ecommerce.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(int id);
    void saveOrUpdateProduct(Product product);
    void deleteProduct(int id);
}
