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
        orderDTO.setUnitPrice(orderDTO.getUnitPrice());

        Client client = order.getClient();
        ClientDTO clientDTO = ClientMapper.buildClientDTO(client);
        orderDTO.setClientDTO(clientDTO);

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
}
