package com.example.SocialNetwork.advice;


import com.example.SocialNetwork.exception.ErrorResponse;
import com.example.SocialNetwork.exception.ResourceNotFoundException;
import jakarta.persistence.Id;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
