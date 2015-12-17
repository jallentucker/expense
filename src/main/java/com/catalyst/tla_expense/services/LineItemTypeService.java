package com.catalyst.tla_expense.services;

import java.util.List;

import com.catalyst.tla_expense.entities.LineItemType;

public interface LineItemTypeService {

	/**
	 * GET
	 * Returns a list of all line item types from the dao
	 * @author cmiller
	 */
	List<LineItemType> getAllLineItemTypes();

}
