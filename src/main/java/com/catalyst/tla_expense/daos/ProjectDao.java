package com.catalyst.tla_expense.daos;


import com.catalyst.tla_expense.entities.Project;
import java.util.List;

public interface ProjectDao {

	/**
	 * Request mapping for GETing a project. Uses a constant located EndpointConstant Class
	 * @return
	 */
	List<Project> getAllProjects();

	/**
	 * request mapping for POST-ing a project. Uses a constant located EndpointConstant Class
	 * @param project
	 * @return
	 * @throws Exception
	 */
	void createProject(Project project);
}
