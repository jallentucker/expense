package com.catalyst.tla_expense.daos.impl;

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

	@Override
	public void createUser(Project project) {
		em.merge(project);
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

}
