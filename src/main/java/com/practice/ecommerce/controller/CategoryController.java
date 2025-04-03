package com.practice.ecommerce.controller;

import com.practice.ecommerce.model.Category;
import com.practice.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String listCategories(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "categories";
    }
    
    @GetMapping("/details/{id}")
    public String showCategoryDetails(@PathVariable int id, Model model) {
        Category category = categoryService.getCategoryById(id);
        model.addAttribute("category", category);
        return "categoryDetails";
    }
    
    @PostMapping("/save")
    public String saveCategory(@ModelAttribute Category category) {
        categoryService.saveOrUpdateCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/categoryForm")
    public String showCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "categoryDetails";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable int id) {
        categoryService.deleteCategory(id);
        return "redirect:/categories";
    }
}


