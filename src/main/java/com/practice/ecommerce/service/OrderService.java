package com.practice.ecommerce.service;

import com.practice.ecommerce.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(int id);
    void saveOrUpdateOrder(Order order);
    void deleteOrder(int id);
    void confirmOrder(int orderId);
}

