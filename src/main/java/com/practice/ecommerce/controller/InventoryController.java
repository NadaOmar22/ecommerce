package com.practice.ecommerce.controller;

import com.practice.ecommerce.model.Inventory;
import com.practice.ecommerce.service.BranchService;
import com.practice.ecommerce.service.InventoryService;
import com.practice.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/inventories")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private BranchService branchService;

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
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("branches", branchService.getAllBranches());
        return "inventoryDetails";
    }
    
    @PostMapping("/save")
    public String saveInventory(@ModelAttribute Inventory inventory, RedirectAttributes redirectAttributes) {
        try {
            inventoryService.saveOrUpdateInventory(inventory);
        }catch (Exception ex){
            redirectAttributes.addFlashAttribute("errorMessage", "There is already inventory for this product and branch");
        }
        return "redirect:/inventories";
    }

    @GetMapping("/inventoryForm")
    public String showInventoryForm(Model model) {
        model.addAttribute("inventory", new Inventory());
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("branches", branchService.getAllBranches());
        return "inventoryDetails";
    }

    @GetMapping("/delete/{id}")
    public String deleteInventory(@PathVariable int id) {
        inventoryService.deleteInventory(id);
        return "redirect:/inventories";
    }
}


