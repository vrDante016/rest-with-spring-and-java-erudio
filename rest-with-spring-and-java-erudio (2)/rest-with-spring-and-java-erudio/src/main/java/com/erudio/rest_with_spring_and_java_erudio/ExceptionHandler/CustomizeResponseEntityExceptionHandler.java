package com.erudio.rest_with_spring_and_java_erudio.ExceptionHandler;

import com.erudio.rest_with_spring_and_java_erudio.Exceptions.Exceptions;
import com.erudio.rest_with_spring_and_java_erudio.Exceptions.UnsupportedMathOperationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;


@ControllerAdvice
@RestController
public class CustomizeResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UnsupportedOperationException.class)
    public final ResponseEntity<Exceptions> handleBadRequestException(
            Exception ex, WebRequest request){
        Exceptions exceptions = new Exceptions(
                new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptions, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Exceptions> handleAllExceptions(
            Exception ex, WebRequest request){
        Exceptions exceptions = new Exceptions(
                new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptions, HttpStatus.BAD_REQUEST);
    }

}
