package com.example.backendspring3.common;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerHandException extends ControllerCommon {
    @ExceptionHandler(MyException.class)
    public ResponseEntity<?> responseError(Exception e){
        return eroHande(e);
    }
}
