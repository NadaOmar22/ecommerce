package com.practice.ecommerce.service;

import com.practice.ecommerce.model.Inventory;

import java.util.List;

public interface InventoryService {
    List<Inventory> getAllInventories();
    Inventory getInventoryById(int id);
    void saveOrUpdateInventory(Inventory inventory);
    void deleteInventory(int id);
}
