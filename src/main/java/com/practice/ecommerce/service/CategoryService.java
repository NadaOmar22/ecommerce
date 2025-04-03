package com.practice.ecommerce.service;

import com.practice.ecommerce.model.Category;
import com.practice.ecommerce.model.Product;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(int id);
    void saveOrUpdateCategory(Category category);
    void deleteCategory(int id);
}
