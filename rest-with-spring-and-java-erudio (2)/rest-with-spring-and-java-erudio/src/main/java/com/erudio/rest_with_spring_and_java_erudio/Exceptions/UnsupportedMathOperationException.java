package com.erudio.rest_with_spring_and_java_erudio.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationException  extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public UnsupportedMathOperationException(String msg){
        super(msg);
    }
}
