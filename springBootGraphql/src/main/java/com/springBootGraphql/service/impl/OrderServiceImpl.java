package com.springBootGraphql.service.impl;

import com.springBootGraphql.helper.Excpetions;
import com.springBootGraphql.model.Order;
import com.springBootGraphql.model.User;
import com.springBootGraphql.repository.OrderRepo;
import com.springBootGraphql.repository.UserRepo;
import com.springBootGraphql.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;
    private final UserRepo userRepo;

    public OrderServiceImpl(OrderRepo orderRepo, UserRepo userRepo) {
        this.orderRepo = orderRepo;
        this.userRepo = userRepo;
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepo.save(order);
    }

    @Override
    public Order updateOrder(Order order) {
        Order order1=orderRepo.findById(order.getId()).get();
        order1.setOrdName(order.getOrdName());
        order1.setOrdDetails(order.getOrdDetails());
        return orderRepo.save(order1);
    }

    @Override
    public Order getOrder(int orderId) {
        return this.orderRepo.findById(orderId).orElseThrow(Excpetions::throwResourceNotFounfException);
    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepo.findAll();
    }

    @Override
    public Boolean deleteOrder(int orderId) {
        Order order=orderRepo.findById(orderId).orElseThrow(Excpetions::throwResourceNotFounfException);
        orderRepo.delete(order);
        return true;
    }
}
