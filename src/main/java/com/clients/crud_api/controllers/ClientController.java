package com.clients.crud_api.controllers;


import com.clients.crud_api.dto.ClientDTO;
import com.clients.crud_api.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ClientDTO insert(@RequestBody ClientDTO clientDTO) {
        ClientDTO dto = clientService.insert(clientDTO);
        return dto;
    }
}
