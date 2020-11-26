package com.capgemini.DealDate.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.capgemini.DealDate.Entity.Order;

/*
@author NAVDEEP TRIPATHI
*/

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	
	@ExceptionHandler(value = OrderNotFoundException.class)
	public ResponseEntity<Object> OrderNotFoundException(OrderNotFoundException obj,WebRequest req){
		Order err = new Order();
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	

}
}
