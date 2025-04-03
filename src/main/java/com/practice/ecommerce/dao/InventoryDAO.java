package com.practice.ecommerce.dao;

import com.practice.ecommerce.model.Inventory;

import java.util.List;

public interface InventoryDAO {
    List<Inventory> getAllInventories();
    Inventory getInventoryById(int id);
    void saveOrUpdateInventory(Inventory inventory);
    void deleteInventory(int id);
}

