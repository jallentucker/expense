package com.catalyst.tla_expense.services.impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.tla_expense.daos.ProjectDao;
import com.catalyst.tla_expense.entities.Project;
import com.catalyst.tla_expense.services.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectDao projectDao;
	
	@Override
	public List<Project> getAllProjects() {
		return projectDao.getAllProjects();
	}

	@Override
	public void createProject(Project project) {
		projectDao.createProject(project);
	}

}
