package com.catalyst.tla_expense.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.tla_expense.entities.LineItem;
import com.catalyst.tla_expense.services.LineItemService;
import com.catalyst.tla_expense.utility.EndpointConstants;

/**
 * Line Item Controller class. Has end points for POST, PUT, DELETE, and GET.
 * 
 * @author cmiller
 */
@RestController
public class LineItemController {
	
	@Autowired
	LineItemService lineItemService;
	
	
	/**
	 * GET
	 * Returns a list of all line items
	 * @author cmiller
	 */
	@RequestMapping(value=EndpointConstants.LINE_ITEM_ENDPOINT, method = RequestMethod.GET)
	public List<LineItem> getAllLineItems(){
		return lineItemService.getAllLineItems();
	}
	
	/**
	 * POST
	 * Sends a Line Item to the service layer
	 * @param LineItem
	 * @author cmiller
	 * @throws Exception 
	 */
	@RequestMapping(value=EndpointConstants.LINE_ITEM_ENDPOINT, method = RequestMethod.POST)
	public LineItem addLineItem(@RequestBody LineItem lineItem) throws Exception{
		return lineItemService.addLineItem(lineItem);
	}
	
	/**
	 * DELETE
	 * Sends a Line Item Id to the service layer
	 * @param LineItemId
	 * @author cmiller
	 */
	@RequestMapping(value=EndpointConstants.LINE_ITEM_ENDPOINT + "/{lineItemId}", method = RequestMethod.DELETE)
	public void deleteLineItemById(@PathVariable Integer lineItemId){
		lineItemService.deleteLineItemById(lineItemId);
	}
	
	/**
	 * PUT
	 * Sends a Line Item to the service layer
	 * @param LineItem
	 * @author cmiller
	 */
	@RequestMapping(value=EndpointConstants.LINE_ITEM_ENDPOINT, method = RequestMethod.PUT)
	public void updateLineItem(@RequestBody LineItem lineItem){
		lineItemService.updateLineItem(lineItem);
	}
	
	
}
