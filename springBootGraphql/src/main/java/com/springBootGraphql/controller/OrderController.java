package com.springBootGraphql.controller;

import com.springBootGraphql.model.Order;
import com.springBootGraphql.model.User;
import com.springBootGraphql.service.OrderService;
import com.springBootGraphql.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OrderController {
    private final OrderService orderService;
    private final UserService userService;

    public OrderController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

//    create order
    @MutationMapping
    public Order createOrder(@Argument String ordDetails, @Argument String ordName, @Argument int userId){
        User user =userService.getUser(userId);
        Order order=new Order();
        order.setOrdDetails(ordDetails);
        order.setOrdName(ordName);
        order.setUser(user);
        return orderService.createOrder(order);
    }

//    getAll order

    @QueryMapping(name = "getOrders")
    public List<Order> getAllOrd(){
        return orderService.getAllOrder();
    }

//    get single order

    @QueryMapping()
    public Order getOrder(@Argument int id ){
        return orderService.getOrder(id);
    }

//    update order
    @MutationMapping(name = "updateOrder")
    public Order updateOrd(@Argument int id, @Argument String ordDetails, @Argument String ordName){
        Order order= new Order();
        order.setId(id);
        order.setOrdDetails(ordDetails);
        order.setOrdName(ordName);
        return orderService.updateOrder(order);
    }


//    delete order
    @MutationMapping(name = "deleteOrder")
    public Boolean deleteOrd(@Argument int id){
        return orderService.deleteOrder(id);
    }
}
