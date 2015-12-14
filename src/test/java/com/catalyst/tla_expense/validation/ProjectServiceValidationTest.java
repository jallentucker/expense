package com.catalyst.tla_expense.validation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.catalyst.tla_expense.daos.ProjectDao;
import com.catalyst.tla_expense.entities.Project;
import com.catalyst.tla_expense.validation.ProjectServiceValidation;

public class ProjectServiceValidationTest {

	private ProjectServiceValidation target;
	private ProjectDao mockProjectDao;
	
	@Before
	public void setup(){
		target = new ProjectServiceValidation();
		mockProjectDao = mock(ProjectDao.class);
		target.setProjectDao(mockProjectDao);
		
		List<Project> existingProjects = new ArrayList<>();
		Project existingProject = new Project();
		existingProject.setProjectName("Project");
		existingProjects.add(existingProject);
		when(mockProjectDao.getAllProjects()).thenReturn(existingProjects);
		
	}
	@Test
	public void testProjectNameWithValidName() throws Exception{
		Project project = new Project();
		project.setProjectName("ProjectName");
		assertTrue(target.projectName(project));
	}

	@Test
	public void testProjectNameWithNameThatIsWhiteSpaces() throws Exception{
		Project project = new Project();
		project.setProjectName("     ");
		assertFalse(target.projectName(project));
	}
	
	@Test(expected=Exception.class)
	public void testProjectNameWithNameThatIsNull() throws Exception{
		Project project = new Project();
		project.setProjectName(null);
		assertTrue(target.projectName(project));
	}
	
	@Test
	public void testProjectNameWithNameThatAlreadyExist() throws Exception{
		Project project = new Project();
		project.setProjectName("Project");
		
		assertFalse(target.projectName(project));
		
	}
	
	@Test
	public void testProjectNameWithNameThatAlreadyExistLowerCase() throws Exception{
		Project project = new Project();
		project.setProjectName("Project");
		
		assertFalse(target.projectName(project));
		
	}
}
