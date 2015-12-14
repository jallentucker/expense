package com.catalyst.tla_expense.services.impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.tla_expense.daos.ProjectDao;
import com.catalyst.tla_expense.entities.Project;
import com.catalyst.tla_expense.services.ProjectService;
import com.catalyst.tla_expense.validation.ProjectServiceValidation;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectDao projectDao;
	
	@Autowired
	ProjectServiceValidation projectServiceValidation;
	
	@Override
	public List<Project> getAllProjects() {
		return projectDao.getAllProjects();
	}

	@Override
	public boolean createProject(Project project) throws Exception {
		try{
			boolean result = false;
			boolean valid = projectServiceValidation.projectName(project);
			if(valid){
				result = true;
				projectDao.createProject(project);
			}
			return result;
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
		
	}

	public void setProjectServiceValidation(ProjectServiceValidation projectServiceValidation) {
		this.projectServiceValidation = projectServiceValidation;
	}

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

}
