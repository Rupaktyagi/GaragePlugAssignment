package com.garagePlugeAssingment.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalException {

	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<MyError> UserException(CustomerException s,WebRequest req){
		
		MyError myerror=new MyError(s.getMessage(), req.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<MyError>(myerror, HttpStatus.BAD_REQUEST);
	}
	
	

	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyError> eException(Exception s,WebRequest req){
		
		MyError myerror=new MyError(s.getMessage(), req.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<MyError>(myerror, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyError> methodException(MethodArgumentNotValidException s){
		
		MyError myerror=new MyError(s.getBindingResult().getFieldError().getDefaultMessage(), "validation error", LocalDateTime.now());
		
		return new ResponseEntity<MyError>(myerror, HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyError> noException(NoHandlerFoundException s,WebRequest req){
		
		MyError myerror=new MyError(s.getMessage(), req.getDescription(false), LocalDateTime.now());
		
		return new ResponseEntity<MyError>(myerror, HttpStatus.BAD_REQUEST);
	}
}
