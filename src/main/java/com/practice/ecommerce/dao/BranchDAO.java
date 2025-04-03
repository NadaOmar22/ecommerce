package com.practice.ecommerce.dao;

import com.practice.ecommerce.model.Branch;

import java.util.List;

public interface BranchDAO {
    List<Branch> getAllBranches();
    Branch getBranchById(int id);
    void saveOrUpdateBranch(Branch branch);
    void deleteBranch(int id);
}

