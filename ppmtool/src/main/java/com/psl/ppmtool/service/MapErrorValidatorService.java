package com.psl.ppmtool.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
@Service
public class MapErrorValidatorService {
	public ResponseEntity<?> MapErrorValidate(BindingResult br){
		Map<String,String> errorMap = new HashMap<String, String>();
		
		if(br.hasErrors()){
			for(FieldError field:br.getFieldErrors()){
				errorMap.put(field.getField(), field.getDefaultMessage());
			}
			return new ResponseEntity<Map<String,String>>(errorMap,HttpStatus.BAD_REQUEST);
		}
	return null;
}
}
