package com.catalyst.tla_expense.daos;


import com.catalyst.tla_expense.entities.Project;
import java.util.List;

public interface ProjectDao {

	List<Project> getAllProjects();

	void createProject(Project project);
}
