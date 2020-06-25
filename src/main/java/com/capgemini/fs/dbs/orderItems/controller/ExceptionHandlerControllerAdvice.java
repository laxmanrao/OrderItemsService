package com.capgemini.fs.dbs.orderItems.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.capgemini.fs.dbs.orderItems.exceptions.ExceptionResponse;
import com.capgemini.fs.dbs.orderItems.exceptions.OrderItemNotFound;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

	@ExceptionHandler(OrderItemNotFound.class)
	public ResponseEntity<ExceptionResponse> handleResourceNotFound(final OrderItemNotFound exception,
			final HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(exception.getMessage());
		error.callerURL(request.getRequestURI());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	ResponseEntity<ExceptionResponse> handleConstraintViolationException(ConstraintViolationException e,final HttpServletRequest request) {
		//return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage("not valid due to validation error:"+e.getMessage());
		error.callerURL(request.getRequestURI());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	ResponseEntity<ExceptionResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e,final HttpServletRequest request) {
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage("not valid due to validation error:"+e.getMessage());
		error.callerURL(request.getRequestURI());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
