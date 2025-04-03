package com.practice.ecommerce.controller;

import com.practice.ecommerce.model.Branch;
import com.practice.ecommerce.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/branches")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @GetMapping
    public String listBranches(Model model) {
        List<Branch> branches = branchService.getAllBranches();
        model.addAttribute("branches", branches);
        return "branches";
    }
    
    @GetMapping("/details/{id}")
    public String showBranchDetails(@PathVariable int id, Model model) {
        Branch branch = branchService.getBranchById(id);
        model.addAttribute("branch", branch);
        return "branchDetails";
    }
    
    @PostMapping("/save")
    public String saveBranch(@ModelAttribute Branch branch) {
        branchService.saveOrUpdateBranch(branch);
        return "redirect:/branches";
    }

    @GetMapping("/branchForm")
    public String showBranchForm(Model model) {
        model.addAttribute("branch", new Branch());
        return "branchDetails";
    }

    @GetMapping("/delete/{id}")
    public String deleteBranch(@PathVariable int id) {
        branchService.deleteBranch(id);
        return "redirect:/branches";
    }
}


