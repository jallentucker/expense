package com.catalyst.tla_expense.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.tla_expense.entities.Project;
import com.catalyst.tla_expense.services.ProjectService;
import com.catalyst.tla_expense.utility.EndpointConstants;

/**
 * Project Controller class. Has end points for POST, and GET.
 * 
 * @author cmiller
 */
@RestController
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
	//request mapping for GETing a project. Uses a constant located EndpointConstant Class
	@RequestMapping(value=EndpointConstants.PROJECT_ENDPOINT, method = RequestMethod.GET)
	public  List<Project> getAllProjects(){
		return projectService.getAllProjects();
	}
	
	//request mapping for POST-ing a project. Uses a constant located EndpointConstant Class
	@RequestMapping(value=EndpointConstants.PROJECT_ENDPOINT, method = RequestMethod.POST)
	public boolean createProject(@RequestBody Project project) throws Exception{
		return projectService.createProject(project);
	}
}
