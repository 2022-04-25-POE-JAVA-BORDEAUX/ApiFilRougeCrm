package com.m2i.apifilrougecrm.dto;

import com.m2i.apifilrougecrm.entity.Client;
import com.m2i.apifilrougecrm.entity.Order;

public class OrderMapper {

    public static OrderDTO buildOrderDTO(Order order){

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setId(order.getId());
        orderDTO.setTypePresta(order.getTypePresta());
        orderDTO.setDesignation(order.getDesignation());
        orderDTO.setNbDays(order.getNbDays());
        orderDTO.setUnitPrice(order.getUnitPrice());

        Client client = order.getClient();
        ClientDTO clientDTO = ClientMapper.buildClientDTO(client);
        orderDTO.setClient(clientDTO);

        switch(order.getState()) {
            case 0:
                orderDTO.setState("CANCELLED");
                break;
            case 1:
                orderDTO.setState("OPTION");
                break;
            case 2:
                orderDTO.setState("CONFIRMED");
                break;
            default:
                orderDTO.setState("");
        }

        return orderDTO;
    }


    public static Order buildOrder(OrderDTO orderDTO, Client client){

        Order order = new Order();

        order.setId(orderDTO.getId());
        order.setTypePresta(orderDTO.getTypePresta());
        order.setDesignation(orderDTO.getDesignation());
        order.setNbDays(orderDTO.getNbDays());
        order.setUnitPrice(orderDTO.getUnitPrice());

        order.setClient(client);

        switch(orderDTO.getState()) {
            case "CANCELLED":
                order.setState(0);
                break;
            case "OPTION":
                order.setState(1);
                break;
            case "CONFIRMED":
                order.setState(2);
                break;
            default:
                order.setState(0);
        }

        return order;
    }
}
