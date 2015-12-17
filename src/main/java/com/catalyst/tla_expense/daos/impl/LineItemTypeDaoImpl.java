package com.catalyst.tla_expense.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.catalyst.tla_expense.daos.LineItemTypeDao;
import com.catalyst.tla_expense.entities.LineItemType;

@Repository
@Transactional
public class LineItemTypeDaoImpl implements LineItemTypeDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<LineItemType> getAllLineItemTypes() {
		return em.createQuery("SELECT l FROM LineItemType l", LineItemType.class).getResultList();
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

}
