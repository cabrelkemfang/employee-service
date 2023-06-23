package io.growtogether.com.employeeservice.mapper;

import io.growtogether.com.employeeservice.dto.ApiResponse;
import io.growtogether.com.employeeservice.dto.NoContentOutput;
import io.growtogether.com.employeeservice.dto.Status;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.info.BuildProperties;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ApiResponseMapper {

    private final BuildProperties buildProperties;

    public NoContentOutput mapToNoContentOutput() {
        return NoContentOutput.builder()
                .apiName(buildProperties.getName())
                .version(buildProperties.getVersion())
                .status(Status.builder().code(HttpStatus.CREATED.value()).value("OK").build())
                .build();
    }

    public <T> ApiResponse<T> mapToApiResponse(T response) {
        var apiResponse = new ApiResponse<T>();
        apiResponse.setResponse(response);
        apiResponse.setApiName(buildProperties.getName());
        apiResponse.setVersion(buildProperties.getVersion());
        apiResponse.setStatus(Status.builder().code(HttpStatus.OK.value()).value("OK").build());
        return apiResponse;
    }

}
