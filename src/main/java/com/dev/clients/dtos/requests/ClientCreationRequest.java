package com.dev.clients.dtos.requests;

import java.time.LocalDateTime;

public record ClientCreationRequest(
        String code,
        String name,
        String email,
        String documentNumber,
        String phoneNumber,
        String cellphoneNumber,
        String gender,
        LocalDateTime birthday,
        String observation,
        boolean isActive
) {
}
