package com.psl.ppmtool.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psl.ppmtool.domain.Project;
import com.psl.ppmtool.service.MapErrorValidatorService;
import com.psl.ppmtool.service.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
	@Autowired
	ProjectService ps ;
	@Autowired
	MapErrorValidatorService errorvalidator;
	
	@PostMapping("")
	public ResponseEntity<?> save0rUpdate(@Valid @RequestBody Project p,BindingResult res){
		 ResponseEntity<?> err = errorvalidator.MapErrorValidate(res);
		 if(err!=null) return err;
		ps.save0rupdate(p);
		return new ResponseEntity<Project>(p, HttpStatus.OK);
	}
	@GetMapping("/{projectId}")
	public ResponseEntity<?> FindProjectID(@PathVariable String projectId){
		 Project project = ps.findProjectByid(projectId);
		return new ResponseEntity<Project>(project,HttpStatus.OK);
	}
	@GetMapping("/all")
	public Iterable<Project>findProjects(){
		return ps.findAllProjects();
	}
	@DeleteMapping("/{projectId}")
	public ResponseEntity<?> deletebyProjectId(@PathVariable String projectId){
		ps.deleteByProjectIdentifier(projectId);
		return new ResponseEntity<String>("Project Deleted Succesfully",HttpStatus.OK);
		
	}
	
	

}
