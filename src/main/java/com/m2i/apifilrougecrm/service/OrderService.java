package com.m2i.apifilrougecrm.service;

import com.m2i.apifilrougecrm.entity.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {


    public List<Order> getOrders(){
        ArrayList<Order> result = new ArrayList<>();
        result.add( new Order("formation", "Formation SpringBoot", 2, 50));
        result.add( new Order("formation", "Formation SpringBoot avancé", 2, 50));
        return result;
    }

}
