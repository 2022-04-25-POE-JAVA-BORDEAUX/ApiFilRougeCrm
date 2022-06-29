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

    public static Client buildClient(ClientDTO clientDTO){

        Client client = new Client();
        client.setId(clientDTO.getId());
        client.setCompanyName(clientDTO.getCompanyName());
        client.setFirstName(clientDTO.getFirstName());
        client.setLastName(clientDTO.getLastName());
        client.setEmail(clientDTO.getEmail());
        client.setPhone(clientDTO.getPhone());
        client.setAddress(clientDTO.getAddress());
        client.setZipCode(clientDTO.getZipCode());
        client.setCity(clientDTO.getCity());
        client.setCountry(clientDTO.getCountry());

        switch (clientDTO.getState()){
            case "INACTIVE":
                client.setState(0);
                break;
            case "ACTIVE":
                client.setState(1);
                break;
            default:
                client.setState(0);
        }

        return client;
    }
}
