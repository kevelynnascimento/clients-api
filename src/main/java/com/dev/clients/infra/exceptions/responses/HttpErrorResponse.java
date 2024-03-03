package com.dev.clients.infra.exceptions.responses;

public record HttpErrorResponse(
        int status,
        String message
) {
}