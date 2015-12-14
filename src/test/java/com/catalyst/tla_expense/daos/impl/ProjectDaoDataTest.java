package com.catalyst.tla_expense.daos.impl;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;
import com.catalyst.tla_expense.daos.impl.ProjectDaoImpl;
import com.catalyst.tla_expense.entities.Project;


public class ProjectDaoDataTest {

	private ProjectDaoImpl target;
	private EntityManager mockEm;
	
	@Before
	public void setup() {
		target = new ProjectDaoImpl();
		mockEm = mock(EntityManager.class);
		target.setEm(mockEm);
	}
	
	/**
	 * Tests that when called GetAllProjects returns a List of projects
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testGetAllProjects() {
		List<Project> expected = new ArrayList();
		
		TypedQuery<Project> mockTypedQuery = mock(TypedQuery.class);
		
		when(mockEm.createQuery(anyString(), eq(Project.class))).thenReturn(mockTypedQuery);
		when(mockTypedQuery.getResultList()).thenReturn(expected);
				
		target.getAllProjects();
		
		verify(mockTypedQuery, times(1)).getResultList();;
	}
	
	/**
	 * Tests that persist() is called on an EntityManager when createProject() 
	 * is called.
	 */
	@Test
	public void testCreateProject() {
		target.createProject(null);
		verify(mockEm, times(1)).merge(null);
	}

}
