package io.growtogether.com.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long employeeId;
    private String employeeName;
    private String age;
    private String position;
}
