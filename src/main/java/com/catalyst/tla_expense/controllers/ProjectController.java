package com.catalyst.tla_expense.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.tla_expense.entities.Project;
import com.catalyst.tla_expense.services.ProjectService;

/**
 * Project Controller class. Has end points for POST.
 * 
 * @author cmiller
 */
@RestController
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
	@RequestMapping(value="/project/post", method = RequestMethod.POST)
	public void createProject(@RequestBody Project project){
		projectService.createProject(project);
	}
	
	
}
