package com.catalyst.tla_expense.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.tla_expense.entities.LineItemType;
import com.catalyst.tla_expense.services.LineItemTypeService;

/**
 * Line Item Controller class. Has end point for GET.
 * 
 * @author cmiller
 */
@RestController
public class LineItemTypeController {

	private static final String LINE_ITEM__TYPE_ENDPOINT = "/lineItemType";
	
	@Autowired
	LineItemTypeService lineItemTypeService;
	
	/**
	 * GET
	 * Returns a list of all line item types
	 * @author cmiller
	 */
	@RequestMapping(value=LINE_ITEM__TYPE_ENDPOINT, method = RequestMethod.GET)
	public List<LineItemType> getAllLineItemTypes(){
		return lineItemTypeService.getAllLineItemTypes();
	}
}
