package com.online.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.online.exception.model.UserCreationException;
import com.online.exception.model.UserNotFoundException;
import com.online.response.ErrorResponse;

@ControllerAdvice
public class UserExceptionHandler {

	@ExceptionHandler(UserCreationException.class)
    public ResponseEntity<?> resourceNotFoundException(UserCreationException ex, WebRequest request) {
         ErrorResponse errorDetails = new ErrorResponse(new Date(), ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(UserNotFoundException ex, WebRequest request) {
         ErrorResponse errorDetails = new ErrorResponse(new Date(), ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
    	ErrorResponse errorDetails = new ErrorResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
