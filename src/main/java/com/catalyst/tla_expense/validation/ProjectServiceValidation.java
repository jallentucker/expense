package com.catalyst.tla_expense.validation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.tla_expense.daos.ProjectDao;
import com.catalyst.tla_expense.entities.Project;

@Service
public class ProjectServiceValidation {
	
	@Autowired
	ProjectDao projectDao;

	public boolean projectName(Project project) throws Exception{
		boolean result = true;
		try{
			String projectName = project.getProjectName().trim();
			if(projectName.equals("")){
				result = false;
			}
			
			List<Project> existingProjects = projectDao.getAllProjects();
			
			for(Project p : existingProjects){
				String lowerCaseProjectName = projectName.toLowerCase();
				String lowerCaseExistingProjectName = p.getProjectName().toLowerCase();
				if(lowerCaseProjectName.equals(lowerCaseExistingProjectName)){
					result = false;
				}
			}
			return result;
		}catch(NullPointerException e){
			throw new Exception("Project Name is null");
		}
	}

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}
	
	
}
