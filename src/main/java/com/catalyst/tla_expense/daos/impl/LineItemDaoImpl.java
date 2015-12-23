package com.catalyst.tla_expense.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.catalyst.tla_expense.daos.LineItemDao;
import com.catalyst.tla_expense.entities.LineItem;


/**
 * 
 * @author TLA
 *
 *	LineItemDaoImpl class
 *	used to do database operations
 *	on our dao. 
 */
@Repository
@Transactional
public class LineItemDaoImpl implements LineItemDao {

	/**
	 * Sets the entity manager
	 * for database operations
	 */
	@PersistenceContext
	private EntityManager em;

	/**
	 * This function returns 
	 * a list of line items
	 *
	 * Will be used to display
	 * line items for reports
	 * in the future. 
	 */
	@Override
	public List<LineItem> getAllLineItems() {
		return em.createQuery("SELECT l FROM LineItem l", LineItem.class).getResultList();
	}

	/**
	 * this function returns a lineitem ID
	 * back to the front end, so that
	 * each line item can be assigned an
	 * number and be merged later on if
	 * changes are made.
	 */
	@Override
	public LineItem addLineItem(LineItem lineItem) {
		return em.merge(lineItem);
	}

	/**
	 * This function take an number
	 * and removes a row from the 
	 * database
	 */
	@Override
	public void deleteLineItemById(Integer lineItemId) {
		LineItem deletedLineItem = getLineItemById(lineItemId);
		em.remove(deletedLineItem);
	}

	/**
	 * used to update. Might
	 * be able to share functionality with 
	 * addLineItem()
	 */
	@Override
	public void updateLineItem(LineItem lineItem) {
		em.merge(lineItem);
	}

	/**
	 * returns a single line item
	 * based on an ID
	 * @param lineItemId
	 * @return
	 */
	private LineItem getLineItemById(Integer lineItemId) {
		return em.createQuery("SELECT l FROM LineItem l WHERE l.lineItemId = :lineItemId", LineItem.class)
				.setParameter("lineItemId", lineItemId).getSingleResult();
	}

	/**
	 * a setter used 
	 * by the Autowiring 
	 * annotation
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}
}
