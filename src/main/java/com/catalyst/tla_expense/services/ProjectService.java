package com.catalyst.tla_expense.services;


import java.util.List;
import com.catalyst.tla_expense.entities.Project;

public interface ProjectService {

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
	boolean createProject(Project project) throws Exception;

}
