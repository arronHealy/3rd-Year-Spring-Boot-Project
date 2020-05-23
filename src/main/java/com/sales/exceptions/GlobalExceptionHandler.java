package com.sales.exceptions;

import javax.servlet.http.HttpServletRequest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	//return error entity if exception caught
	@ExceptionHandler(value= {Exception.class, RuntimeException.class})
	public ResponseEntity<Object> handleExceptions(HttpServletRequest req, Exception ex)
	{
		return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
