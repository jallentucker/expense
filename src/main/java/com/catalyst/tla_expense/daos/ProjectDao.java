package com.catalyst.tla_expense.daos;

import java.util.List;

import com.catalyst.tla_expense.entities.Project;

public interface ProjectDao {
	List<Project> getAllProjects();

	void createProject(Project project);
}
