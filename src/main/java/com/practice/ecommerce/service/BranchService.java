package com.practice.ecommerce.service;

import com.practice.ecommerce.model.Branch;

import java.util.List;

public interface BranchService {
    List<Branch> getAllBranches();
    Branch getBranchById(int id);
    void saveOrUpdateBranch(Branch branch);
    void deleteBranch(int id);
}
