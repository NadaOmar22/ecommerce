package com.practice.ecommerce.daoImpl;

import com.practice.ecommerce.dao.InventoryDAO;
import com.practice.ecommerce.model.Inventory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InventoryDAOImpl implements InventoryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Inventory> getAllInventories() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Inventory", Inventory.class).list();
    }

    @Override
    public Inventory getInventoryById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Inventory.class, id);
    }

    @Override
    public void saveOrUpdateInventory(Inventory category) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(category);
    }

    @Override
    public void deleteInventory(int id) {
        Session session = sessionFactory.getCurrentSession();
        Inventory inventory = session.get(Inventory.class, id);
        if (inventory != null) {
            session.delete(inventory);
        }
    }
}


