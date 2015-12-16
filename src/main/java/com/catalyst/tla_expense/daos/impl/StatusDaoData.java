package com.catalyst.tla_expense.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.catalyst.tla_expense.daos.StatusDao;
import com.catalyst.tla_expense.entities.Status;

@Repository
@Transactional
public class StatusDaoData implements StatusDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}

	/**
	 * Retrieves all statuses in the database
	 * @return full list of stored statuses
	 */
	@Override
	public List<Status> getStatuses() {
			return em.
				createQuery("SELECT e FROM status e ORDER BY e.statusId", Status.class).
				getResultList();
	}


	/**
	 * Search Statuses by name and return the Status if found
	 * @param statusName
	 * @return status with matching name
	 */
	public Status getStatusById(int id) {
			return em
				.createQuery("SELECT c FROM status c WHERE c.statusId = :n", Status.class)
				.setParameter("n", id)
				.getSingleResult();
	}
}
