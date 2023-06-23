package io.growtogether.com.employeeservice.exception;

import lombok.Generated;

public class ApiException extends RuntimeException {
    private static final String DEFAULT_MESSAGE = "Unhandled server exception";
    private final int code;

    public ApiException(String message, int code) {
        super(message);
        this.code = code;
    }

    public ApiException(int code) {
        super(DEFAULT_MESSAGE);
        this.code = code;
    }

    public ApiException(String message, int code, Throwable ex) {
        super(message, ex);
        this.code = code;
    }

    @Generated
    public int getCode() {
        return this.code;
    }

}
