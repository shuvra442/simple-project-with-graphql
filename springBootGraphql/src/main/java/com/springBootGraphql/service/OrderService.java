package com.springBootGraphql.service;

import com.springBootGraphql.model.Order;
import com.springBootGraphql.model.User;

import java.util.List;


public interface OrderService {

    public Order createOrder(Order order);

    public Order updateOrder(Order order);

    public Order getOrder(int orderId);
    public List<Order> getAllOrder();

    public Boolean deleteOrder(int orderId);
}
