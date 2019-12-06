package com.psl.ppmtool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.ppmtool.domain.Project;
import com.psl.ppmtool.repositories.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepository pr;
	public Project save0rupdate(Project p){
		return pr.save(p);
	}

}
