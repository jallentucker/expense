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
	
	@Override
	public List<LineItem> getAllLineItems() {
		return lineItemDao.getAllLineItems();
	}

	@Override
	public boolean addLineItem(LineItem lineItem) throws Exception {
		boolean result = false;
		boolean valid = lineItemValidation.validateLineItem(lineItem);
		if(valid){
			result = true;
			lineItemDao.addLineItem(lineItem);
		}
		return result;
		
	}

	@Override
	public void deleteLineItemById(Integer lineItemId) {
		lineItemDao.deleteLineItemById(lineItemId);
		
	}

	@Override
	public void updateLineItem(LineItem lineItem) {
		lineItemDao.updateLineItem(lineItem);
		
	}

	public void setLineItemDao(LineItemDao lineItemDao) {
		this.lineItemDao = lineItemDao;
	}

	public void setLineItemValidation(LineItemValidation lineItemValidation) {
		this.lineItemValidation = lineItemValidation;
	}

	
}
