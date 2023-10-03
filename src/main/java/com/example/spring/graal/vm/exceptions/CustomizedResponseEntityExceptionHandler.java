package com.example.spring.graal.vm.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception exception, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                request.getContextPath(),
                exception.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                LocalDateTime.now());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PublisherNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handlePublisherNotFoundException(PublisherNotFoundException publisherNotFoundException, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                request.getContextPath(),
                publisherNotFoundException.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AuthorNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleAuthorNotFoundException(AuthorNotFoundException authorNotFoundException, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                request.getContextPath(),
                authorNotFoundException.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

}
