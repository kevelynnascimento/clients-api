package com.dev.clients.api.controllers;

import com.dev.clients.domain.services.ClientService;
import com.dev.clients.dtos.requests.ClientCreationRequest;
import com.dev.clients.dtos.requests.ClientUpdateRequest;
import com.dev.clients.dtos.responses.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping()
    public ResponseEntity<List<ClientListingResponse>> findAll() {
        var clients = this.clientService.findAll();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("{id}")
    public ResponseEntity<ClientFindingResponse> findById(@PathVariable UUID id) {
        var client = this.clientService.findById(id);
        return ResponseEntity.ok(client);
    }

    @PostMapping()
    public ResponseEntity<ClientCreationResponse> create(@RequestBody ClientCreationRequest request) {
        var client = this.clientService.create(request);
        return ResponseEntity.ok(client);
    }

    @PutMapping("{id}")
    public ResponseEntity<ClientUpdateResponse> update(@PathVariable UUID id, @RequestBody ClientUpdateRequest request) {
        var client = this.clientService.update(id, request);
        return ResponseEntity.ok(client);
    }

    @PostMapping("{id}/disabling")
    public ResponseEntity<ClientDisablingResponse> disable(@PathVariable UUID id) {
        var client = this.clientService.disable(id);
        return ResponseEntity.ok(client);
    }
}
