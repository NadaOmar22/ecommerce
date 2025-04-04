package com.practice.ecommerce.dao;

import com.practice.ecommerce.model.Order;
import com.practice.ecommerce.model.OrderItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderDAO {
    List<Order> getAllOrders();
    Order getOrderById(int id);
    void saveOrUpdateOrder(Order order);
    void deleteOrder(int id);
    void confirmOrder(int orderId);
    List<OrderItem> getOrderItems(int orderId);
}

