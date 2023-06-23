package io.growtogether.com.employeeservice.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @NotEmpty
    private String name;
    @NotEmpty
    private Long departmentId;
    private String age;
    @NotEmpty
    private String position;
}
