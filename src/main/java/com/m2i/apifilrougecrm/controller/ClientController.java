package com.m2i.apifilrougecrm.controller;

import com.m2i.apifilrougecrm.dto.ClientDTO;
import com.m2i.apifilrougecrm.dto.ClientMapper;
import com.m2i.apifilrougecrm.entity.Client;
import com.m2i.apifilrougecrm.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<ClientDTO> getClient(@PathVariable("id") Long id){

        Optional<Client> clientOptional =  clientService.getClient(id);

        if(clientOptional.isPresent()) {
            Client client = clientOptional.get();
            ClientDTO clientDTO = ClientMapper.buildClientDTO(client);
            return ResponseEntity.status(HttpStatus.OK).body(clientDTO);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // retourne un 404
        }
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
