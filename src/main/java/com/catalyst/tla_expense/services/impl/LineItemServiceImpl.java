package com.catalyst.tla_expense.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.tla_expense.daos.LineItemDao;
import com.catalyst.tla_expense.entities.LineItem;
import com.catalyst.tla_expense.services.LineItemService;
import com.catalyst.tla_expense.validation.LineItemValidation;

@Service
public class LineItemServiceImpl implements LineItemService {

	@Autowired
	LineItemDao lineItemDao;
	
	@Autowired 
	LineItemValidation lineItemValidation;
	
	/**
	 * GET
	 * Returns a list of all line items from the dao
	 * @author cmiller
	 */
	@Override
	public List<LineItem> getAllLineItems() {
		return lineItemDao.getAllLineItems();
	}

	/**
	 * POST
	 * Sends a Line Item to the dao layer
	 * @param LineItem
	 * @author cmiller
	 * @return 
	 * @throws Exception 
	 */
	@Override
	public int addLineItem(LineItem lineItem) throws Exception {
		boolean result = false;
		boolean valid = lineItemValidation.validateLineItem(lineItem);
		if(valid){
			return lineItemDao.addLineItem(lineItem);
		}
		return -1;
	}

	/**
	 * DELETE
	 * Sends a Line Item Id to the dao layer
	 * @param LineItemId
	 * @author cmiller
	 */
	@Override
	public void deleteLineItemById(Integer lineItemId) {
		lineItemDao.deleteLineItemById(lineItemId);
		
	}
	
	/**
	 * PUT
	 * Sends a Line Item to the dao layer
	 * @param LineItem
	 * @author cmiller
	 */
	@Override
	public void updateLineItem(LineItem lineItem) {
		lineItemDao.updateLineItem(lineItem);
		
	}
	
	/**
	 * Sets the lineItemDao.
	 * @param lineItemDao
	 */
	public void setLineItemDao(LineItemDao lineItemDao) {
		this.lineItemDao = lineItemDao;
	}

	/**
	 * sets the lineItemValidation class in order to validate input.
	 * @param lineItemValidation
	 */
	public void setLineItemValidation(LineItemValidation lineItemValidation) {
		this.lineItemValidation = lineItemValidation;
	}

	
}
