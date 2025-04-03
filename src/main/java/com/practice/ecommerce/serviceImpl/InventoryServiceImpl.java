package com.practice.ecommerce.serviceImpl;

import com.practice.ecommerce.dao.InventoryDAO;
import com.practice.ecommerce.model.Inventory;
import com.practice.ecommerce.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryDAO inventoryDAO;

    @Transactional
    @Override
    public List<Inventory> getAllInventories() {
        return inventoryDAO.getAllInventories();
    }

    @Transactional
    @Override
    public Inventory getInventoryById(int id) {
        return inventoryDAO.getInventoryById(id);
    }

    @Transactional
    @Override
    public void saveOrUpdateInventory(Inventory category) {
        inventoryDAO.saveOrUpdateInventory(category);
    }

    @Transactional
    @Override
    public void deleteInventory(int id) {
        inventoryDAO.deleteInventory(id);
    }
}

