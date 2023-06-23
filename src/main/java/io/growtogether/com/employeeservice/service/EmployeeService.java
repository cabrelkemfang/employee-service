package io.growtogether.com.employeeservice.service;

import io.growtogether.com.employeeservice.dto.EmployeeRequest;
import io.growtogether.com.employeeservice.dto.EmployeeResponse;
import io.growtogether.com.employeeservice.dto.NoContentOutput;

import java.util.List;

public interface EmployeeService {
    List<EmployeeResponse> findAllEmployee();

    List<EmployeeResponse> findEmployeeByDepartmentId(Long departmentId);

    EmployeeResponse findEmployeeById(Long employeeId);

    NoContentOutput addEmployee(EmployeeRequest employeeRequest);
}
