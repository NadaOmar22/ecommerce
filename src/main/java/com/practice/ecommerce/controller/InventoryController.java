package com.practice.ecommerce.controller;

import com.practice.ecommerce.model.Branch;
import com.practice.ecommerce.model.Inventory;
import com.practice.ecommerce.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/inventories")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public String listInventories(Model model) {
        List<Inventory> inventories = inventoryService.getAllInventories();
        model.addAttribute("inventories", inventories);
        return "inventories";
    }
    
    @GetMapping("/details/{id}")
    public String showInventoryDetails(@PathVariable int id, Model model) {
        Inventory inventory = inventoryService.getInventoryById(id);
        model.addAttribute("inventory", inventory);
        return "inventoryDetails";
    }
    
    @PostMapping("/save")
    public String saveInventory(@ModelAttribute Inventory inventory) {
        inventoryService.saveOrUpdateInventory(inventory);
        return "redirect:/inventories";
    }

    @GetMapping("/inventoryForm")
    public String showInventoryForm(Model model) {
        model.addAttribute("inventory", new Branch());
        return "inventoryDetails";
    }

    @GetMapping("/delete/{id}")
    public String deleteInventory(@PathVariable int id) {
        inventoryService.deleteInventory(id);
        return "redirect:/inventories";
    }
}


