package com.pointOfSale.suvaraj.project1.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleUserAlreadyExistsException(UserAlreadyExistsException ex) {
        
    	Map<String,String> response = new HashMap<>();
    	response.put("message", ex.getMessage());
    	
    	return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}