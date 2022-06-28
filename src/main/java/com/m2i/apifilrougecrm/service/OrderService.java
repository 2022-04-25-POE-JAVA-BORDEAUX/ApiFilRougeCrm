package com.m2i.apifilrougecrm.service;

import com.m2i.apifilrougecrm.entity.Order;
import com.m2i.apifilrougecrm.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getOrders(){

        return orderRepository.findAll();
    }

}
