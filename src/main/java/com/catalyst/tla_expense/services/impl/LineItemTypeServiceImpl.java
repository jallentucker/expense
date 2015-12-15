package com.catalyst.tla_expense.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalyst.tla_expense.daos.LineItemTypeDao;
import com.catalyst.tla_expense.entities.LineItemType;
import com.catalyst.tla_expense.services.LineItemTypeService;

@Service
public class LineItemTypeServiceImpl implements LineItemTypeService {

	@Autowired
	LineItemTypeDao lineItemTypeDao;
	
	@Override
	public List<LineItemType> getAllLineItemTypes() {
		return lineItemTypeDao.getAllLineItemTypes();
	}

	public void setLineItemTypeDao(LineItemTypeDao lineItemTypeDao) {
		this.lineItemTypeDao = lineItemTypeDao;
	}

}
