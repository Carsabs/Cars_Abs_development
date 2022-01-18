package com.ibm.cars.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController
public class ExceptionHandling extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public  ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
		
		Exceptions exceptions = new Exceptions(new Date(), ex.getMessage(),
				request.getDescription(false));
		
		return new ResponseEntity(exceptions,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(DataNotFound.class)
	public final ResponseEntity<Object> handleUserNotFoundException(DataNotFound ex, WebRequest request) {
		Exceptions exceptions = new Exceptions(new Date(), ex.getMessage(),
				request.getDescription(false));
		
		return new ResponseEntity(exceptions,HttpStatus.NOT_FOUND);
	}

}
