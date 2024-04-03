package com.atguigu.error;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public Object arithmeticException(ArithmeticException e){
        String message = e.getMessage();
        System.out.println(message);
        return message;
    }

    @ExceptionHandler(NullPointerException.class)
    public Object nullPointException(NullPointerException e){
        return e.getMessage();
    }
}
