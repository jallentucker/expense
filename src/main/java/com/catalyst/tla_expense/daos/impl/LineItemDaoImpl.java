package com.catalyst.tla_expense.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.catalyst.tla_expense.daos.LineItemDao;
import com.catalyst.tla_expense.entities.LineItem;

@Repository
@Transactional
public class LineItemDaoImpl implements LineItemDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<LineItem> getAllLineItems() {
		return em.createQuery("SELECT l FROM LineItem l", LineItem.class).getResultList();
	}

	@Override
	public void addLineItem(LineItem lineItem) {
		em.merge(lineItem);
	}

	@Override
	public void deleteLineItemById(Integer lineItemId) {
		LineItem deletedLineItem = getLineItemById(lineItemId);
		em.remove(deletedLineItem);
	}

	@Override
	public void updateLineItem(LineItem lineItem) {
		em.merge(lineItem);

	}

	private LineItem getLineItemById(Integer lineItemId) {
		return em.createQuery("SELECT l FROM LineItem l WHERE l.lineItemId = :lineItemId", LineItem.class)
				.setParameter("lineItemId", lineItemId).getSingleResult();
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
}
