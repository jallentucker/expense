package com.catalyst.tla_expense.services.impl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.catalyst.tla_expense.daos.ProjectDao;
import com.catalyst.tla_expense.entities.Project;
import com.catalyst.tla_expense.services.impl.ProjectServiceImpl;
import com.catalyst.tla_expense.validation.ProjectServiceValidation;

public class ProjectServiceImplTest {

	private ProjectServiceImpl target;
	private ProjectServiceValidation mockProjectServiceValidation;
	private ProjectDao mockProjectDao;
	
	@Before
	public void setup(){
		target = new ProjectServiceImpl();
		mockProjectServiceValidation = mock(ProjectServiceValidation.class);
		mockProjectDao = mock(ProjectDao.class);
	}
	
	@Test
	public void testCreateProjectWhenIsValidReturnsTrue() throws Exception{
		target.setProjectDao(mockProjectDao);
		target.setProjectServiceValidation(mockProjectServiceValidation);
		
		Project project = new Project();
		
		when(mockProjectServiceValidation.projectName(project)).thenReturn(true);
		boolean expected = true;
		boolean actual = target.createProject(project);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCreateProjectWhenIsValidReturnsFalse() throws Exception{
		target.setProjectDao(mockProjectDao);
		target.setProjectServiceValidation(mockProjectServiceValidation);
		
		Project project = new Project();
		
		when(mockProjectServiceValidation.projectName(project)).thenReturn(false);
		boolean expected = false;
		boolean actual = target.createProject(project);
		assertEquals(expected, actual);
	}
	
	@Test(expected=Exception.class)
	public void testCatchExceptionWhenValidateThrowsException() throws Exception{
		target.setProjectDao(mockProjectDao);
		target.setProjectServiceValidation(mockProjectServiceValidation);
		
		Project project = new Project();
		
		when(mockProjectServiceValidation.projectName(project)).thenThrow(new Exception("hey an exception"));
		target.createProject(project);
	}
	
	@Test
	public void testGetAllProjects(){
		target.setProjectDao(mockProjectDao);
		
		List<Project> expected = new ArrayList<>();
		
		when(mockProjectDao.getAllProjects()).thenReturn(expected);
		
		List<Project> actual = target.getAllProjects();
		
		assertEquals(expected, actual);
		
	}
}
