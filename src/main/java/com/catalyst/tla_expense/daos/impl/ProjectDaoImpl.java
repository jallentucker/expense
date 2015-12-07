package com.catalyst.tla_expense.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.catalyst.tla_expense.daos.ProjectDao;
import com.catalyst.tla_expense.entities.Project;


@Repository
@Transactional
public class ProjectDaoImpl implements ProjectDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Project> getAllProjects() {
		return em.createQuery("SELECT p FROM project p", Project.class).getResultList();
	}
	
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public void createProject(Project project) {
		em.merge(project);
		
	}

}
