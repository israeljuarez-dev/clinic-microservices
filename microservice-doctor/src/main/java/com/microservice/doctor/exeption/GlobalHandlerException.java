package com.microservice.doctor.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalHandlerException {
    @ExceptionHandler(DoctorNotFoundException.class)
    public ResponseEntity<Map<String, String>>DoctorNotFoundExceptionHandler(Exception e){
        Map<String, String> response = new HashMap<>();
        response.put("error", "Resource not found");
        response.put("message", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
