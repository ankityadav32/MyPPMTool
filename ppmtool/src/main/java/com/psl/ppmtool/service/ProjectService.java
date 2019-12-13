package com.psl.ppmtool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.ppmtool.domain.Project;
import com.psl.ppmtool.exceptions.ProjectIdException;
import com.psl.ppmtool.exceptions.ProjectListException;
import com.psl.ppmtool.repositories.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepository pr;
	public Project save0rupdate(Project p){
		try{
			p.setProjectIdentifier(p.getProjectIdentifier().toUpperCase());
			return pr.save(p);
		}
		catch(Exception ex){
			throw new ProjectIdException("Project ID "+p.getProjectIdentifier().toUpperCase()+" already exists");
		}
		
	}
	public Project findProjectByid(String Projectid){
		
		Project project = pr.findByProjectIdentifier(Projectid.toUpperCase());
		if(project ==null){
			throw new ProjectIdException("ProjectID "+Projectid+" does not exist");
		}
		return project;
		
	}
	public Iterable<Project>findAllProjects(){
		
		 Iterable<Project> projectList= pr.findAll();
		 if(projectList != null){
			 throw new ProjectListException("Projects not found");
		 }
		 return projectList;
	}

}
