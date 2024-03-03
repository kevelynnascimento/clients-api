package com.dev.clients.mappers;

import com.dev.clients.domain.entites.ClientEntity;
import com.dev.clients.dtos.responses.ClientFindingResponse;
import com.dev.clients.dtos.responses.ClientListingResponse;

import java.time.LocalDateTime;
import java.util.List;

public class ClientMap {
    public static List<ClientListingResponse> mapToListingResponse(List<ClientEntity> input) {
        return input.stream().map(x -> new ClientListingResponse(
                x.getId(),
                x.getCode(),
                x.getName(),
                x.getEmail(),
                x.getDocumentNumber(),
                x.getPhoneNumber(),
                x.getCellphoneNumber(),
                x.getCreationDate(),
                x.getDisablingDate()
        )).toList();
    }

    public static ClientFindingResponse mapToFindingResponse(ClientEntity input) {
        return new ClientFindingResponse(
                input.getId(),
                input.getCode(),
                input.getName(),
                input.getEmail(),
                input.getDocumentNumber(),
                input.getPhoneNumber(),
                input.getCellphoneNumber(),
                input.getGender(),
                input.getBirthday(),
                input.getObservation(),
                input.getDisablingDate()
        );
    }
}
