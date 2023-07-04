package com.wallet.finances.exceptions.password;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.wallet.finances.exceptions.ErrorMessage;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class PasswordExceptionHandler {
    
    @ExceptionHandler
    ResponseEntity<ErrorMessage> handleException(InvalidPasswordException exception){

        ErrorMessage errorMessage = new ErrorMessage();

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        
        errorMessage.setMessage(exception.getMessage());
        errorMessage.setStatus(HttpStatus.BAD_REQUEST.value());
        errorMessage.setTimestamp(System.currentTimeMillis());
        errorMessage.setPath(request.getRequestURI());

        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
