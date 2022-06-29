package com.m2i.apifilrougecrm.controller;

import com.m2i.apifilrougecrm.entity.Client;
import com.m2i.apifilrougecrm.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("clients")
    public List<Client> getClients() {
        return clientService.getAllClients();
    }

    @PostMapping("clients")
    public void createClient(@RequestBody Client client){
        clientService.createClient(client);
    }
}
