package com.dev.clients.infra.repositories;

import com.dev.clients.domain.entites.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<ClientEntity, UUID> {
    List<ClientEntity> findAllByOrderByCreationDateDesc();
}
