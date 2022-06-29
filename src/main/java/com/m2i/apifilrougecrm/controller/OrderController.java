package com.m2i.apifilrougecrm.controller;


import com.m2i.apifilrougecrm.dto.OrderDTO;
import com.m2i.apifilrougecrm.dto.OrderMapper;
import com.m2i.apifilrougecrm.entity.Client;
import com.m2i.apifilrougecrm.entity.Order;
import com.m2i.apifilrougecrm.service.ClientService;
import com.m2i.apifilrougecrm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ClientService clientService;


    @GetMapping("orders")
    public List<OrderDTO> getOrders(){
        List<Order> orders = orderService.getOrders();
        List<OrderDTO> ordersDTO = new ArrayList<>();
        for(Order order : orders){
            OrderDTO orderDTO = OrderMapper.buildOrderDTO(order);
            ordersDTO.add(orderDTO);
        }
        return ordersDTO;
    }

    @PostMapping("orders")
    public void createOrder(@RequestBody OrderDTO orderDTO) {

        Long clientId = orderDTO.getClient().getId();
        Client client = clientService.getClient(clientId).get();//ATTENTION
        Order order = OrderMapper.buildOrder(orderDTO, client);
        orderService.createOrder(order);
    }

    @GetMapping("orders/{id}")
    public OrderDTO getOrder(@PathVariable("id") Long id) {

        Order order = orderService.getOrder(id);
        OrderDTO orderDTO = OrderMapper.buildOrderDTO(order);
        return orderDTO;
    }

    @PutMapping("orders/{id}")
    public void updateOrder(@RequestBody OrderDTO orderDTO) {
        Long clientId = orderDTO.getClient().getId();
        Client client = clientService.getClient(clientId).get();//ATTENTION
        Order order = OrderMapper.buildOrder(orderDTO, client);

        orderService.updateOrder(order);
    }

    @DeleteMapping("orders/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }

}
