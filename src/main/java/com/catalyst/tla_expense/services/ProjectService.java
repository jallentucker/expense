package com.catalyst.tla_expense.services;

import java.util.List;

import com.catalyst.tla_expense.entities.Project;

public interface ProjectService {

	List<Project> getAllProjects();

	void createProject(Project project);

}
