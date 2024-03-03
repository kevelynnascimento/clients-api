package com.dev.clients.dtos.responses;

import java.time.LocalDateTime;
import java.util.UUID;

public record ClientListingResponse(
        UUID id,
        String code,
        String name,
        String email,
        String documentNumber,
        String phoneNumber,
        String cellphoneNumber,
        LocalDateTime creationDate,
        LocalDateTime disablingDate
) {
}
