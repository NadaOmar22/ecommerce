package com.practice.ecommerce.controller;

import com.practice.ecommerce.model.Order;
import com.practice.ecommerce.service.BranchService;
import com.practice.ecommerce.service.OrderService;
import com.practice.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;
    @Autowired
    private BranchService branchService;

    @GetMapping
    public String listOrders(Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "orders";
    }

    @GetMapping("/details/{id}")
    public String showOrderDetails(@PathVariable int id, Model model) {
        Order order = orderService.getOrderById(id);
        model.addAttribute("order", order);
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("branches", branchService.getAllBranches());
        return "orderDetails";
    }

    @PostMapping("/save")
    public String saveOrder(@ModelAttribute Order order) {
        orderService.saveOrUpdateOrder(order);
        return "redirect:/orders";
    }

    @GetMapping("/orderForm")
    public String showOrderForm(Model model) {
        model.addAttribute("order", new Order());
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("branches", branchService.getAllBranches());
        return "orderDetails";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
        return "redirect:/orders";
    }

    @PostMapping("/confirm/{orderId}/{branchId}")
    public String confirmOrder(@PathVariable int orderId, @PathVariable int branchId, Model model) {
        try {
            orderService.confirmOrder(orderId);
            return "redirect:/orders?success";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "orderDetails"; // Redirect back to the order details page with an error message
        }
    }
}


