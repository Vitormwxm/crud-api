package com.clients.crud_api.repositories;

import com.clients.crud_api.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
