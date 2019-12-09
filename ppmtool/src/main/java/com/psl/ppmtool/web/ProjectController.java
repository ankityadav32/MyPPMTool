package com.psl.ppmtool.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psl.ppmtool.domain.Project;
import com.psl.ppmtool.service.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
	@Autowired
	ProjectService ps ;
	
	@PostMapping("")
	public ResponseEntity<?> save0rUpdate(@Valid @RequestBody Project p,BindingResult res){
		
		if(res.hasErrors()){
			return new ResponseEntity<String>("Invalid Project Object",HttpStatus.BAD_REQUEST);
		}
		ps.save0rupdate(p);
		return new ResponseEntity<Project>(p, HttpStatus.OK);
	}
	

}
