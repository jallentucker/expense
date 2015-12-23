package com.catalyst.tla_expense.daos;

import java.util.List;

import com.catalyst.tla_expense.entities.LineItem;

public interface LineItemDao {

	/**
	 * GET
	 * Returns a list of all line items from the database
	 * @author cmiller
	 */
	public List<LineItem> getAllLineItems();

	/**
	 * POST
	 * Sends a Line Item to be persisted to the database
	 * @param LineItem
	 * @author cmiller
	 */
	public LineItem addLineItem(LineItem lineItem);

	/**
	 * DELETE
	 * Sends a Line Item Id to the database to get deleted
	 * @param LineItemId
	 * @author cmiller
	 */
	public void deleteLineItemById(Integer id);

	/**
	 * PUT
	 * Sends a Line Item to the databased to be merged with another line item
	 * @param LineItem
	 * @author cmiller
	 * @return 
	 */
	public void updateLineItem(LineItem lineItem);

}
