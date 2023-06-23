package io.growtogether.com.employeeservice.controller;


import io.growtogether.com.employeeservice.dto.ApiResponse;
import io.growtogether.com.employeeservice.dto.EmployeeRequest;
import io.growtogether.com.employeeservice.dto.EmployeeResponse;
import io.growtogether.com.employeeservice.dto.NoContentOutput;
import io.growtogether.com.employeeservice.mapper.ApiResponseMapper;
import io.growtogether.com.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final ApiResponseMapper apiResponseMapper;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<EmployeeResponse> findEmployeeById(@PathVariable(value = "id") Long employeeId) {
        log.info(" Get Employee By Identification {}", employeeId);
        var employee = this.employeeService.findEmployeeById(employeeId);
        return this.apiResponseMapper.mapToApiResponse(employee);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<List<EmployeeResponse>> getAllEmployee() {
        log.info(" Get All Employee ");
        var employee = this.employeeService.findAllEmployee();
        return this.apiResponseMapper.mapToApiResponse(employee);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public NoContentOutput saveEmployee(@RequestBody EmployeeRequest employeeRequest) {
        log.info(" Save departments {}", employeeRequest);
        this.employeeService.addEmployee(employeeRequest);
        return this.apiResponseMapper.mapToNoContentOutput();
    }

    @GetMapping(value = "/departments/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<List<EmployeeResponse>> findEmployeeByDepartmentId(@PathVariable(name = "id") Long departmentId) {
        log.info(" Get Employee By department Id {}", departmentId);
        var employee = this.employeeService.findEmployeeByDepartmentId(departmentId);
        return this.apiResponseMapper.mapToApiResponse(employee);
    }

}
