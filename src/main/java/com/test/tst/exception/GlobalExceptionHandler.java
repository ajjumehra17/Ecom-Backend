package com.test.tst.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.test.tst.model.Product;

@RestControllerAdvice

public class GlobalExceptionHandler {

	
	
	@ExceptionHandler(ResourceNotFoundException.class)
 public String HandelResourcerNotFoundException(ResourceNotFoundException ex) {
		return ex.getMessage();
	}
}
