package com.psl.ppmtool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class ProjectListException extends RuntimeException {

	public ProjectListException(String message) {
		super(message);
	}
}
