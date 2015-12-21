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

	/**
	 * Checks to see that the name of the project is not whitespace and that it does
	 * not already exist in the database.
	 * @param project
	 * @return boolean
	 * @throws Exception
	 */
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

	/**
	 * Sets the ProjectDao to exchange data
	 * @param projectDao
	 */
	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}
}
