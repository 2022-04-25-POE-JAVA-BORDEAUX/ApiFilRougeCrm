package com.m2i.apifilrougecrm.dto;

import com.m2i.apifilrougecrm.entity.Client;

public class ClientMapper {

    public static ClientDTO buildClientDTO(Client client) {

        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(client.getId());
        clientDTO.setCompanyName(client.getCompanyName());
        clientDTO.setFirstName(client.getFirstName());
        clientDTO.setLastName(client.getLastName());
        clientDTO.setEmail(client.getEmail());
        clientDTO.setPhone(client.getPhone());
        clientDTO.setAddress(client.getAddress());
        clientDTO.setZipCode(client.getZipCode());
        clientDTO.setCity(client.getCity());
        clientDTO.setCountry(client.getCountry());

        switch (client.getState()){
            case 0:
                clientDTO.setState("INACTIVE");
                break;
            case 1:
                clientDTO.setState("ACTIVE");
                break;
            default:
                clientDTO.setState("");
        }

        return clientDTO;
    }
}
