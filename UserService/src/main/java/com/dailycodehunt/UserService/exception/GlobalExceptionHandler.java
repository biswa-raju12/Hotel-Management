package com.dailycodehunt.UserService.exception;

import com.dailycodehunt.UserService.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException exp){

        String msg = exp.getMessage();

        ApiResponse response= ApiResponse.builder().message(msg).success(true).Status(HttpStatus.NOT_FOUND).build();

        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);

    }
}
