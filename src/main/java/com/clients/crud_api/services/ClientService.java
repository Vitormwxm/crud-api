package com.clients.crud_api.services;

import com.clients.crud_api.dto.ClientDTO;
import com.clients.crud_api.entities.Client;
import com.clients.crud_api.repositories.ClientRepository;
import com.clients.crud_api.services.exceptions.DatabaseException;
import com.clients.crud_api.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.hibernate.LazyInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> client = clientRepository.findAll(pageable);
        return client.map(x -> new ClientDTO(x));
    }

    public ClientDTO findById(Long id) {
        Client result = clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        return new ClientDTO(result);
    }

    public ClientDTO insert(ClientDTO clientDTO) {
        Client client = new Client();
        client.setName(clientDTO.getName());
        client.setCpf(clientDTO.getCpf());
        client.setIncome(clientDTO.getIncome());
        client.setChildren(clientDTO.getChildren());
        client.setBirthDate(clientDTO.getBirthDate());

        client = clientRepository.save(client);
        return  new ClientDTO(client);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO clientDTO) {

        if (clientRepository.existsById(id) == false) {
            throw new DatabaseException("Recurso não encontrado no banco");
        }

        Client client = clientRepository.getReferenceById(id);

        copyDtoToEntity(clientDTO, client);

        client = clientRepository.save(client);
        return new ClientDTO(client);

    }

    @Transactional
    public void delete(Long id) {

        if (clientRepository.existsById(id) == false) {
            throw new ResourceNotFoundException("Cliente não existe na base de dados");
        }
        clientRepository.deleteById(id);
    }

    private void copyDtoToEntity(ClientDTO clientDTO, Client client) {
        client.setName(clientDTO.getName());
        client.setCpf(clientDTO.getCpf());
        client.setIncome(clientDTO.getIncome());
        client.setChildren(clientDTO.getChildren());
        client.setBirthDate(clientDTO.getBirthDate());
    }
}
