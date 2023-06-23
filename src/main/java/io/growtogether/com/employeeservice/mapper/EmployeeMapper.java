package io.growtogether.com.employeeservice.mapper;


import io.growtogether.com.employeeservice.domain.Employee;
import io.growtogether.com.employeeservice.dto.EmployeeRequest;
import io.growtogether.com.employeeservice.dto.EmployeeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface EmployeeMapper {

    @Mapping(target = "employeeName", source = "employeeRequest.name")
    Employee mapToEmployee(EmployeeRequest employeeRequest);

    EmployeeResponse mapToEmployeeResponse(Employee employee);
}
