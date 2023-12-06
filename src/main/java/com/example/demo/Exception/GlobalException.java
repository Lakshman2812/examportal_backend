package com.example.demo.Exception;

import com.example.demo.payloads.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
       @ExceptionHandler(ResourceFoundException.class)
       public ResponseEntity<ExceptionResponse> resourceFoundException(ResourceFoundException ex){
            String message=ex.getMessage();
            return new ResponseEntity<>(new ExceptionResponse(1,message), HttpStatus.BAD_REQUEST);
       }
}
