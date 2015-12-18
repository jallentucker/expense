package com.catalyst.tla_expense.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.catalyst.tla_expense.daos.LineItemTypeDao;
import com.catalyst.tla_expense.entities.LineItemType;

/**
 * 
 * @author TLA
 *
 *	LineItemType is used for
 *	setting a predetermined 
 *	set of types on our 
 *	LineItems
 */
@Repository
@Transactional
public class LineItemTypeDaoImpl implements LineItemTypeDao {
	
	/**
	 * Entity manager is used
	 * for database operations
	 */
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * this GETs all line item types
	 * and sends the list to the front
	 * end to be displayed on the 
	 * creation of a line item. 
	 */
	@Override
	public List<LineItemType> getAllLineItemTypes() {
		return em.createQuery("SELECT l FROM LineItemType l", LineItemType.class).getResultList();
	}

	/**
	 * this setter is used by
	 * the Autorwiring annotation
	 * @param em
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}

}
