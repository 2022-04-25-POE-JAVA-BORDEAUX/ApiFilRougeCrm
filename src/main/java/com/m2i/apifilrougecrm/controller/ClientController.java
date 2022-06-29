package com.m2i.apifilrougecrm.controller;

import com.m2i.apifilrougecrm.dto.ClientDTO;
import com.m2i.apifilrougecrm.dto.ClientMapper;
import com.m2i.apifilrougecrm.entity.Client;
import com.m2i.apifilrougecrm.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("clients")
    public List<ClientDTO> getClients() {
        List<Client> clients = clientService.getAllClients();
        List<ClientDTO> clientsDTO = new ArrayList<>();
        for(Client client : clients){
            ClientDTO clientDTO = ClientMapper.buildClientDTO(client);
            clientsDTO.add(clientDTO);
        }
        return clientsDTO;
    }

    @PostMapping("clients")
    public void createClient(@RequestBody ClientDTO clientDTO){
        Client client = ClientMapper.buildClient(clientDTO);
        clientService.createClient(client);
    }

    @GetMapping("clients/{id}")
    public ClientDTO getClient(@PathVariable("id") Long id){
        Client client =  clientService.getClient(id);
        ClientDTO clientDTO = ClientMapper.buildClientDTO(client);
        return clientDTO;
    }

    @PutMapping("clients/{id}")
    public void updateClient(@RequestBody ClientDTO clientDTO){
        Client client = ClientMapper.buildClient(clientDTO);
        clientService.updateClient(client);
    }

    @DeleteMapping("clients/{id}")
    public void deleteClient(@PathVariable("id") Long id){
        clientService.deleteClient(id);
    }
}
