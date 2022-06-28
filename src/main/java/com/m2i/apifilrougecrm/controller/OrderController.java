package com.m2i.apifilrougecrm.controller;


import com.m2i.apifilrougecrm.entity.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {

    @GetMapping("/orders")
    public List<Order> getOrders(){

        ArrayList<Order> result = new ArrayList<>();
        result.add( new Order("formation", "Formation SpringBoot", 2, 50));
        result.add( new Order("formation", "Formation SpringBoot avancé", 2, 50));
        return result;
    }
}
