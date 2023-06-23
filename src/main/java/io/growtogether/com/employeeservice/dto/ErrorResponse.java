package io.growtogether.com.employeeservice.dto;

import lombok.Builder;

@Builder
public record ErrorResponse(
        String version,
        String apiName,
        String message,
        Status response) {
}
