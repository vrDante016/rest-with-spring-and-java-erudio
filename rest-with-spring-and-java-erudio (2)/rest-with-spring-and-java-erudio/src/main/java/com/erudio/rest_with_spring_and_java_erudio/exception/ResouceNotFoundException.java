package com.erudio.rest_with_spring_and_java_erudio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResouceNotFoundException extends RuntimeException {
    private static final long serialVersinUID = 1L;

    public ResouceNotFoundException(String msg){
        super(msg);
    }
}
