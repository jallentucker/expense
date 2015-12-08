package com.catalyst.tla_expense.service_test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.catalyst.tla_expense.entities.Project;
import com.catalyst.tla_expense.services.impl.ProjectServiceImpl;
import com.catalyst.tla_expense.validation.ProjectServiceValidation;

public class ProjectServiceImplTest {

	private ProjectServiceImpl target;
	private ProjectServiceValidation mockProjectServiceValidation;
	
	@Before
	public void setup(){
		target = new ProjectServiceImpl();
		mockProjectServiceValidation = mock(ProjectServiceValidation.class);
	}
	
	@Test
	public void startTest() throws Exception{
		Project project = new Project();
		project.setProjectName("project");
		mockProjectServiceValidation = mock(ProjectServiceValidation.class);
		target.setProjectServiceValidation(mockProjectServiceValidation);
		when(mockProjectServiceValidation.projectName(project)).thenReturn(true);
		boolean expected = true;
		boolean actual = target.createProject(project);
		assertEquals(expected, actual);
	}
}
