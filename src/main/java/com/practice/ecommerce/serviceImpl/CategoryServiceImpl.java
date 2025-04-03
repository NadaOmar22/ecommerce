package com.practice.ecommerce.serviceImpl;

import com.practice.ecommerce.dao.CategoryDAO;
import com.practice.ecommerce.model.Category;
import com.practice.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    @Transactional
    @Override
    public List<Category> getAllCategories() {
        return categoryDAO.getAllCategories();
    }

    @Transactional
    @Override
    public Category getCategoryById(int id) {
        return categoryDAO.getCategoryById(id);
    }

    @Transactional
    @Override
    public void saveOrUpdateCategory(Category category) {
        categoryDAO.saveOrUpdateCategory(category);
    }

    @Transactional
    @Override
    public void deleteCategory(int id) {
        categoryDAO.deleteCategory(id);
    }
}

