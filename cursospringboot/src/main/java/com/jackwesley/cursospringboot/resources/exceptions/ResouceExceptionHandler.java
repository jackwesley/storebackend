package com.jackwesley.cursospringboot.resources.exceptions;

import com.jackwesley.cursospringboot.services.exceptions.DataIntegrityException;
import com.jackwesley.cursospringboot.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResouceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException exception,
                                                        HttpServletRequest request){

        StandardError standardError = new StandardError(HttpStatus.NOT_FOUND.value(),
                exception.getMessage(), System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);

    }

    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException exception,
                                                        HttpServletRequest request){

        StandardError standardError = new StandardError(HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(), System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(standardError);

    }
}
