package com.wallet.finances.exceptions.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.wallet.finances.exceptions.ErrorMessage;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class UserExceptionHandler {
    
    @ExceptionHandler
    ResponseEntity<ErrorMessage> handleExcpetion(UserNotFoundException exception){
        ErrorMessage errorMessage = new ErrorMessage();

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        
        errorMessage.setMessage(exception.getMessage());
        errorMessage.setStatus(HttpStatus.NOT_FOUND.value());
        errorMessage.setTimestamp(System.currentTimeMillis());
        errorMessage.setPath(request.getRequestURI());

        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    ResponseEntity<ErrorMessage> handleExcpetion(BadCredentialsException exception){
        ErrorMessage errorMessage = new ErrorMessage();

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        
        errorMessage.setMessage("Incorrect Password!");
        errorMessage.setStatus(HttpStatus.FORBIDDEN.value());
        errorMessage.setTimestamp(System.currentTimeMillis());
        errorMessage.setPath(request.getRequestURI());

        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler
    ResponseEntity<ErrorMessage> handleExcpetion(UserAlreadyExistsException exception){
        ErrorMessage errorMessage = new ErrorMessage();

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        
        errorMessage.setMessage(exception.getMessage());
        errorMessage.setStatus(HttpStatus.CONFLICT.value());
        errorMessage.setTimestamp(System.currentTimeMillis());
        errorMessage.setPath(request.getRequestURI());

        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.CONFLICT);
    }

    @ExceptionHandler
    ResponseEntity<ErrorMessage> handleException(InvalidDataException exception){

        ErrorMessage errorMessage = new ErrorMessage();

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        
        errorMessage.setMessage(exception.getMessage());
        errorMessage.setStatus(HttpStatus.BAD_REQUEST.value());
        errorMessage.setTimestamp(System.currentTimeMillis());
        errorMessage.setPath(request.getRequestURI());

        return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
