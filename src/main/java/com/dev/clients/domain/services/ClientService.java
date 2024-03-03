package com.dev.clients.domain.services;

import com.dev.clients.domain.entites.ClientEntity;
import com.dev.clients.dtos.requests.ClientCreationRequest;
import com.dev.clients.dtos.requests.ClientUpdateRequest;
import com.dev.clients.dtos.responses.*;
import com.dev.clients.infra.exceptions.types.HttpBadRequestException;
import com.dev.clients.infra.repositories.ClientRepository;
import com.dev.clients.mappers.ClientMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<ClientListingResponse> findAll() {
        var clients = this.clientRepository.findAllByOrderByCreationDateDesc();

        return ClientMap.mapToListingResponse(clients);
    }

    public ClientFindingResponse findById(UUID id) {
        var client = this.getById(id);
        return ClientMap.mapToFindingResponse(client);
    }

    public ClientCreationResponse create(ClientCreationRequest request) {
        var client = new ClientEntity(
                request.code(),
                request.name(),
                request.email(),
                request.documentNumber(),
                request.phoneNumber(),
                request.cellphoneNumber(),
                request.gender(),
                request.birthday(),
                request.observation()
        );

        if (!request.isActive()) {
            var now = LocalDateTime.now();
            client.setDisablingDate(now);
        }

        this.clientRepository.save(client);

        return new ClientCreationResponse(client.getId());
    }

    public ClientUpdateResponse update(UUID id, ClientUpdateRequest request) {
        var client = this.getById(id);

        client.setName(request.name());
        client.setEmail(request.email());
        client.setDocumentNumber(request.documentNumber());
        client.setPhoneNumber(request.phoneNumber());
        client.setCellphoneNumber(request.cellphoneNumber());

        client.setGender(request.gender());
        client.setBirthday(request.birthday());
        client.setObservation(request.observation());

        if (!request.isActive()) {
            var now = LocalDateTime.now();
            client.setDisablingDate(now);
        }

        this.clientRepository.save(client);

        return new ClientUpdateResponse(true);
    }

    public ClientDisablingResponse disable(UUID id) {
        var client = this.getById(id);

        var now = LocalDateTime.now();

        client.setDisablingDate(now);

        this.clientRepository.save(client);

        return new ClientDisablingResponse(true);
    }

    private ClientEntity getById(UUID id) {
        var optionalClient = this.clientRepository.findById(id);

        if (optionalClient.isEmpty())
            throw new HttpBadRequestException("Client was not found.");

        return optionalClient.get();
    }
}
