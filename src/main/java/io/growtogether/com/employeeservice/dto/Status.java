package io.growtogether.com.employeeservice.dto;

import lombok.Builder;

@Builder
public record Status(
        int code,
        String value) {
}
