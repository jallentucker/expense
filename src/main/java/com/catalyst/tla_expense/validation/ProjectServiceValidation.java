package com.catalyst.tla_expense.validation;

import org.springframework.stereotype.Service;

import com.catalyst.tla_expense.entities.Project;

@Service
public class ProjectServiceValidation {

	public boolean projectName(Project project) throws Exception{
		boolean result = true;
		try{
			String projectName = project.getProjectName().trim();
			if(projectName.equals("")){
				result = false;
			}
			return result;
		}catch(NullPointerException e){
			throw new Exception("Project Name is null");
		}
	}
}
