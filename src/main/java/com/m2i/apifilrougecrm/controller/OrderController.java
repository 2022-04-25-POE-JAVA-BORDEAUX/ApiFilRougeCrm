package com.m2i.apifilrougecrm.controller;


import com.m2i.apifilrougecrm.dto.OrderDTO;
import com.m2i.apifilrougecrm.dto.OrderMapper;
import com.m2i.apifilrougecrm.entity.Order;
import com.m2i.apifilrougecrm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("orders")
    public List<Order> getOrders(){

        return orderService.getOrders();
    }

    @PostMapping("orders")
    public void createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
    }

    @GetMapping("orders/{id}")
    public OrderDTO getOrder(@PathVariable("id") Long id) {

        Order order = orderService.getOrder(id);
        OrderDTO orderDTO = OrderMapper.buildOrderDTO(order);
        return orderDTO;
    }

    @PutMapping("orders/{id}")
    public void updateOrder(@RequestBody Order order) {
        orderService.updateOrder(order);
    }

    @DeleteMapping("orders/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }

}
