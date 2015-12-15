package com.catalyst.tla_expense.services;

import java.util.List;

import com.catalyst.tla_expense.entities.LineItem;

public interface LineItemService {

	/**
	 * GET
	 * Returns a list of all line items from the dao
	 * @author cmiller
	 */
	public List<LineItem> getAllLineItems();

	/**
	 * POST
	 * Sends a Line Item to the dao layer
	 * @param LineItem
	 * @author cmiller
	 */
	public void addLineItem(LineItem lineItem);

	/**
	 * DELETE
	 * Sends a Line Item Id to the dao layer
	 * @param LineItemId
	 * @author cmiller
	 */
	public void deleteLineItemById(Integer lineItemId);

	/**
	 * PUT
	 * Sends a Line Item to the dao layer
	 * @param LineItem
	 * @author cmiller
	 */
	public void updateLineItem(LineItem lineItem);

}
