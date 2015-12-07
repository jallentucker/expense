package com.catalyst.tla_expense.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.catalyst.tla_expense.entities.Project;
import com.catalyst.tla_expense.services.ProjectService;

public class ProjectController {
	@Autowired
	ProjectService projectService;
	
	@RequestMapping(value="/project/get", method = RequestMethod.GET)
	public  List<Project> getAllProjects(){
		return projectService.getAllProjects();
	}
	
	@RequestMapping(value="/project/post", method = RequestMethod.POST)
	public void createProject(@RequestBody Project project){
		projectService.createProject(project);
	}
}
