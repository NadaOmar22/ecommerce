package com.practice.ecommerce.dao;

import com.practice.ecommerce.model.Product;
import java.util.List;

public interface ProductDAO {
    List<Product> getAllProducts();
    Product getProductById(int id);
    void saveOrUpdateProduct(Product product);
    void deleteProduct(int id);
}

