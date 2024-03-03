package com.dev.clients.dtos.responses;

import java.time.LocalDateTime;
import java.util.UUID;

public record ClientFindingResponse(
        UUID id,
        String code,
        String name,
        String email,
        String documentNumber,
        String phoneNumber,
        String cellphoneNumber,
        String gender,
        LocalDateTime birthday,
        String observation,
        LocalDateTime disablingDate
) {
}
