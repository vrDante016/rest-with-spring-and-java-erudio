package com.erudio.rest_with_spring_and_java_erudio.exceptionHandler;

import com.erudio.rest_with_spring_and_java_erudio.exception.Exceptions;
import com.erudio.rest_with_spring_and_java_erudio.exception.ResouceNotFoundException;
import org.springframework.http.HttpStatus;
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

    @ExceptionHandler(ResouceNotFoundException.class)
    public final ResponseEntity<Exceptions> handleNotFoundExceptions(
            Exception ex, WebRequest request){
        Exceptions exceptions = new Exceptions(
                new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptions, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Exceptions> handleAllExceptions(
            Exception ex, WebRequest request){
        Exceptions exceptions = new Exceptions(
                new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptions, HttpStatus.BAD_REQUEST);
    }
}
