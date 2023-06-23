package io.growtogether.com.employeeservice.exception;

import io.growtogether.com.employeeservice.dto.ErrorResponse;
import io.growtogether.com.employeeservice.dto.Status;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.boot.info.BuildProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class ControllerExceptionHandler {

    private static final String DEFAULT_MESSAGE = "unhandled server message";
    private final BuildProperties buildProperties;

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponse> resourceNotFoundException(ApiException ex, WebRequest request) {
        log.warn(" Error Message {}", ExceptionUtils.getMessage(ex));
        log.warn(" E {}", request);
        var message = buildErrorResponse(ex.getMessage(), ex.getCode());

        return new ResponseEntity<>(message, HttpStatus.valueOf(ex.getCode()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> globalExceptionHandler(Exception ex, WebRequest request) {
        log.warn(" Error Message {}", ExceptionUtils.getMessage(ex));
        var message = buildErrorResponse(DEFAULT_MESSAGE, HttpStatus.INTERNAL_SERVER_ERROR.value());

        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ErrorResponse buildErrorResponse(String message, int status) {
        return ErrorResponse.builder()
                .apiName(buildProperties.getName())
                .version(buildProperties.getVersion())
                .message(message)
                .response(Status.builder().value("KO").code(status).build())
                .build();
    }
}
