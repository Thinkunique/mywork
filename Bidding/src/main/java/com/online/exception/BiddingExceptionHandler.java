package com.online.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.online.exception.model.BiddingException;
import com.online.response.ErrorResponse;

@RestControllerAdvice
public class BiddingExceptionHandler {

	@ExceptionHandler(BiddingException.class)
    public ResponseEntity<?> resourceNotFoundException(BiddingException ex, WebRequest request) {
         ErrorResponse errorDetails = new ErrorResponse(new Date(), ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ExceptionHandler(AuctionException.class)
    public ResponseEntity<?> resourceNotFoundException(AuctionException ex, WebRequest request) {
         ErrorResponse errorDetails = new ErrorResponse(new Date(), ex.getMessage(), request.getDescription(false));
         return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
    	ErrorResponse errorDetails = new ErrorResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
}
