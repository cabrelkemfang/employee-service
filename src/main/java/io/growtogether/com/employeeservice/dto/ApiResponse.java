package io.growtogether.com.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String version;
    private String apiName;
    private Status status;
    T response;
}

