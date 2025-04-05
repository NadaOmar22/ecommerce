package com.practice.ecommerce.serviceImpl;

import com.practice.ecommerce.dao.OrderDAO;
import com.practice.ecommerce.model.Order;
import com.practice.ecommerce.model.OrderItem;
import com.practice.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Transactional
    @Override
    public List<Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }

    @Transactional
    @Override
    public Order getOrderById(int id) {
        return orderDAO.getOrderById(id);
    }

    @Transactional
    @Override
    public void saveOrUpdateOrder(Order order) {
        orderDAO.saveOrUpdateOrder(order);
    }

    @Transactional
    @Override
    public void deleteOrder(int id) {
        orderDAO.deleteOrder(id);
    }

    @Transactional
    @Override
    public void confirmOrder(int orderId) {
        orderDAO.confirmOrder(orderId);
    }

    @Override
    public List<OrderItem> getOrderItems(int orderId) {
        return orderDAO.getOrderItems(orderId);
    }
}

