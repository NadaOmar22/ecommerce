package com.practice.ecommerce.controller;

import com.practice.ecommerce.model.Category;
import com.practice.ecommerce.model.Product;
import com.practice.ecommerce.service.CategoryService;
import com.practice.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    // List all products
    @GetMapping
    public String listProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "productList";
    }

    // Show product details and edit form
    @GetMapping("/details/{id}")
    public String showProductDetails(@PathVariable int id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "productDetails";
    }

    // Save new or updated product
    @PostMapping("/save")
    public String saveProduct(@ModelAttribute Product product) {
        productService.saveOrUpdateProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/ProductForm")
    public String showProductForm(Model model) {
        model.addAttribute("product", new Product());
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "productDetails";
    }

    // Delete product
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}


