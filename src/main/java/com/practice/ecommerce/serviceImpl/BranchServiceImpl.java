package com.practice.ecommerce.serviceImpl;

import com.practice.ecommerce.dao.BranchDAO;
import com.practice.ecommerce.model.Branch;
import com.practice.ecommerce.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    private BranchDAO branchDAO;

    @Transactional
    @Override
    public List<Branch> getAllBranches() {
        return branchDAO.getAllBranches();
    }

    @Transactional
    @Override
    public Branch getBranchById(int id) {
        return branchDAO.getBranchById(id);
    }

    @Transactional
    @Override
    public void saveOrUpdateBranch(Branch branch) {
        branchDAO.saveOrUpdateBranch(branch);
    }

    @Transactional
    @Override
    public void deleteBranch(int id) {
        branchDAO.deleteBranch(id);
    }
}

