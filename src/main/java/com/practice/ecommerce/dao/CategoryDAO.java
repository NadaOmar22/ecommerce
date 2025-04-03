package com.practice.ecommerce.dao;

import com.practice.ecommerce.model.Category;

import java.util.List;

public interface CategoryDAO {
    List<Category> getAllCategories();
    Category getCategoryById(int id);
    void saveOrUpdateCategory(Category category);
    void deleteCategory(int id);
}

