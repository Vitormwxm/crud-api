package com.clients.crud_api.controllers;


import com.clients.crud_api.dto.ClientDTO;
import com.clients.crud_api.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( value = "clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<ClientDTO> findAll() {
        List<ClientDTO> dto = clientService.findAll();
        return dto;
    }

    @GetMapping(value = "/{id}")
    public ClientDTO findById(@PathVariable Long id) {
        ClientDTO dto = clientService.findById(id);
        return dto;
    }
}
