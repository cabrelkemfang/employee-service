package io.growtogether.com.employeeservice.service.impl;

import io.growtogether.com.employeeservice.dto.EmployeeRequest;
import io.growtogether.com.employeeservice.dto.EmployeeResponse;
import io.growtogether.com.employeeservice.dto.NoContentOutput;
import io.growtogether.com.employeeservice.exception.ApiException;
import io.growtogether.com.employeeservice.mapper.ApiResponseMapper;
import io.growtogether.com.employeeservice.mapper.EmployeeMapper;
import io.growtogether.com.employeeservice.repository.EmployeeRepository;
import io.growtogether.com.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final ApiResponseMapper apiResponseMapper;

    @Override
    public List<EmployeeResponse> findAllEmployee() {
        var employee = this.employeeRepository.findAll();
        return employee.stream()
                .map(employeeMapper::mapToEmployeeResponse)
                .toList();
    }

    @Override
    public List<EmployeeResponse> findEmployeeByDepartmentId(Long departmentId) {
        var employee = this.employeeRepository.findAllByDepartmentId(departmentId);
        return employee.stream()
                .map(employeeMapper::mapToEmployeeResponse)
                .toList();
    }

    @Override
    public EmployeeResponse findEmployeeById(Long employeeId) {
        var employee = this.employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ApiException("No Employee found  With Id : " + employeeId, HttpStatus.NOT_FOUND.value()));
        return this.employeeMapper.mapToEmployeeResponse(employee);
    }

    @Override
    public NoContentOutput addEmployee(EmployeeRequest employeeRequest) {
        var employee = this.employeeMapper.mapToEmployee(employeeRequest);
        this.employeeRepository.save(employee);
        return this.apiResponseMapper.mapToNoContentOutput();
    }
}
