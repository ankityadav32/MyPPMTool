package com.psl.ppmtool.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Project> save0rUpdate(@RequestBody Project p){
		ps.save0rupdate(p);
		
		return new ResponseEntity<Project>(p, HttpStatus.OK);
	}
	

}
