package com.psl.ppmtool.exceptions;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class CustomResponseEntityExceptionhandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<Object> CustomResponseEntityException(ProjectIdException ex,WebRequest wb){ 
		ProjectIdExceptionResponse exceptionResponse = new ProjectIdExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object>(exceptionResponse,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler
	public ResponseEntity<Object> CustomEmptyListHandler(ProjectListException ex,WebRequest wb){
		Map<String, String> exceptionResponse = new ProjectListExceptionResponse().EmptyProjectListResponse("ProjectList", ex.getMessage());
		return new ResponseEntity<Object>(exceptionResponse,HttpStatus.OK);
	}
}
