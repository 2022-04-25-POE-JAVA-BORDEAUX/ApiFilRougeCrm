package com.m2i.apifilrougecrm.controller;


import com.m2i.apifilrougecrm.entity.Order;
import com.m2i.apifilrougecrm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
