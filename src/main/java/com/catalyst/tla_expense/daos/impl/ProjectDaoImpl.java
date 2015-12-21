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
public class ProjectDaoImpl implements ProjectDao {

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * Request mapping for GETing a project. Uses a constant located EndpointConstant Class
	 * @return
	 */
	@Override
	public List<Project> getAllProjects() {
		return em.createQuery("SELECT p FROM project p", Project.class).getResultList();
	}
	
	/**
	 * request mapping for POST-ing a project. Uses a constant located EndpointConstant Class
	 * @param project
	 * @return
	 * @throws Exception
	 */
	@Override
	public void createProject(Project project) {
		em.merge(project);
	}
	
	/**
	 * Sets the entity manager
	 * @param em
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	public EntityManager getEm() {
		return em;
	};
}
