package com.practice.ecommerce.serviceImpl;

import com.practice.ecommerce.dao.ProductDAO;
import com.practice.ecommerce.model.Product;
import com.practice.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Transactional
    @Override
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    @Transactional
    @Override
    public Product getProductById(int id) {
        return productDAO.getProductById(id);
    }

    @Transactional
    @Override
    public void saveOrUpdateProduct(Product product) {
        productDAO.saveOrUpdateProduct(product);
    }

    @Transactional
    @Override
    public void deleteProduct(int id) {
        productDAO.deleteProduct(id);
    }
}

