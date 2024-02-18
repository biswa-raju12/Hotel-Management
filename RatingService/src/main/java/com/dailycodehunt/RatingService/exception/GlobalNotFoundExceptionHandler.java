package com.dailycodehunt.RatingService.exception;

import com.dailycodehunt.RatingService.entities.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalNotFoundExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> HandleResourceNotFoundException(ResourceNotFoundException ex)
    {
        String msg = ex.getMessage();

        ApiResponse apiResponse=ApiResponse.builder().message(msg).success(true).status(HttpStatus.NOT_FOUND).build();

        return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
    }
}
