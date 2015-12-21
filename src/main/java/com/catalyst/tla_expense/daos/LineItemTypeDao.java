package com.catalyst.tla_expense.daos;

import java.util.List;

import com.catalyst.tla_expense.entities.LineItemType;

public interface LineItemTypeDao {
	
	/**
	 * GET
	 * Returns a list of all line item types
	 * @author cmiller
	 */
	List<LineItemType> getAllLineItemTypes();

}
