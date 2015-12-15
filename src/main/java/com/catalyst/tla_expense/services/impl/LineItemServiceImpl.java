package com.catalyst.tla_expense.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.tla_expense.daos.LineItemDao;
import com.catalyst.tla_expense.entities.LineItem;
import com.catalyst.tla_expense.services.LineItemService;

@Service
public class LineItemServiceImpl implements LineItemService {

	@Autowired
	LineItemDao lineItemDao;
	
	@Override
	public List<LineItem> getAllLineItems() {
		return lineItemDao.getAllLineItems();
	}

	@Override
	public void addLineItem(LineItem lineItem) {
		lineItemDao.addLineItem(lineItem);
		
	}

	@Override
	public void deleteLineItemById(Integer lineItemId) {
		lineItemDao.deleteLineItemById(lineItemId);
		
	}

	@Override
	public void updateLineItem(LineItem lineItem) {
		lineItemDao.updateLineItem(lineItem);
		
	}

}
