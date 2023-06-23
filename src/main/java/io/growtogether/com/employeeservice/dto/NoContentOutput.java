package io.growtogether.com.employeeservice.dto;

import lombok.Builder;

@Builder
public record NoContentOutput(
        String version,
        String apiName,
        Status status) {
}
