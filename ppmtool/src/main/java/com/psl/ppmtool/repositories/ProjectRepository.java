package com.psl.ppmtool.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.psl.ppmtool.domain.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Long> {
	Project findByProjectIdentifier(String ProjectId);
	@Override
	public Iterable<Project> findAll();
	
	
	
}
