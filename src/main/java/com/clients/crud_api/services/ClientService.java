package com.clients.crud_api.services;

import com.clients.crud_api.dto.ClientDTO;
import com.clients.crud_api.entities.Client;
import com.clients.crud_api.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<ClientDTO> findAll() {
        List<Client> client = clientRepository.findAll();
        return client.stream().map(x -> new ClientDTO(x)).toList();
    }
}
