package com.practice.ecommerce.daoImpl;

import com.practice.ecommerce.dao.OrderDAO;
import com.practice.ecommerce.model.Branch;
import com.practice.ecommerce.model.Inventory;
import com.practice.ecommerce.model.Order;
import com.practice.ecommerce.model.OrderItem;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Order> getAllOrders() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Orders", Order.class).list();
    }

    @Override
    public Order getOrderById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Order.class, id);
    }

    @Override
    public void saveOrUpdateOrder(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(order);
    }

    @Override
    public void deleteOrder(int id) {
        Session session = sessionFactory.getCurrentSession();
        Order order = session.get(Order.class, id);
        if (order != null) {
            session.delete(order);
        }
    }

    @Override
    @Transactional
    public void confirmOrder(int orderId) {
        Session session = sessionFactory.getCurrentSession();

        Order order = session.get(Order.class, orderId);
        if (order == null) {
            throw new RuntimeException("Order not found");
        }

        Branch branch = order.getBranch();
        if (branch == null) {
            throw new RuntimeException("Branch not found");
        }

        for (OrderItem orderItem : order.getOrderItems()) {
            Query query = session.createQuery(
                    "FROM Inventory inventory WHERE inventory.branch = :branch AND inventory.product = :product", Inventory.class);
            query.setParameter("branch", branch);
            query.setParameter("product", orderItem.getProduct());

            Integer inventoryId = query.getFirstResult();
            if (inventoryId == null) {
                throw new RuntimeException("Product not found in any branch");
            }

            Inventory inventory = session.get(Inventory.class, inventoryId);

            if (inventory.getQuantity() < orderItem.getQuantity()) {
                throw new RuntimeException("Cannot confirm order: Out of stock for " + orderItem.getProduct().getName());
            }

            // Reduce stock
            inventory.setQuantity(inventory.getQuantity() - orderItem.getQuantity());
            session.update(inventory);
        }

        // Update order status
        order.setStatus("CONFIRMED");
        session.update(order);
    }


}


