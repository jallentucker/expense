package com.catalyst.tla_expense.validation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import com.catalyst.tla_expense.entities.LineItem;
import com.catalyst.tla_expense.entities.LineItemType;

public class LineItemValidationTest {

	private LineItemValidation target;
	
	@Before
	public void setup(){
		target = new LineItemValidation();
	}
	
	@Test
	public void testValidateLineItemWithValidLineItem() throws Exception{
		LineItem lineItem = new LineItem();
		
		LineItemType lineItemType = new LineItemType();
		lineItemType.setLineItemType("type");
		
		lineItem.setMonetaryAmount(2.4);
		lineItem.setLineItemType(lineItemType);
		
		assertTrue(target.validateLineItem(lineItem));
	}
	
	@Test (expected=Exception.class)
	public void testValidateLineItemWithInvalidMonetaryAmount() throws Exception{
		LineItem lineItem = new LineItem();
		
		LineItemType lineItemType = new LineItemType();
		lineItemType.setLineItemType("type");
		
		lineItem.setLineItemType(lineItemType);
		lineItem.setMonetaryAmount(0);
		
		assertFalse(target.validateLineItem(lineItem));
	}
	
	@Test (expected=Exception.class)
	public void testValidateLineItemWithNullLineItemType() throws Exception{
		LineItem lineItem = new LineItem();
		
		LineItemType lineItemType = new LineItemType();
		lineItemType.setLineItemType(null);
		
		lineItem.setLineItemType(lineItemType);
		lineItem.setMonetaryAmount(2.35);
		
		target.validateLineItem(lineItem);
	}
	
	@Test
	public void testValidateLineItemWithInvalidLineItemType() throws Exception{
		LineItem lineItem = new LineItem();
		
		LineItemType lineItemType = new LineItemType();
		lineItemType.setLineItemType("");
		
		lineItem.setLineItemType(lineItemType);
		lineItem.setMonetaryAmount(2.35);
		
		assertFalse(target.validateLineItem(lineItem));
	}
	
	@Test
	public void testValidateLineItemTypeWithValidLineItemType() throws Exception{
		LineItem lineItem = new LineItem();
		
		LineItemType lineItemType = new LineItemType();
		lineItemType.setLineItemType("type");
		lineItem.setLineItemType(lineItemType);
		
		assertTrue(target.validateLineItemType(lineItem));
	}
	
	@Test
	public void testValidateLineItemTypeWithInvalidLineItemType() throws Exception{
		LineItem lineItem = new LineItem();
		
		LineItemType lineItemType = new LineItemType();
		lineItemType.setLineItemType("");
		lineItem.setLineItemType(lineItemType);
		
		assertFalse(target.validateLineItemType(lineItem));
	}
	
	@Test (expected=Exception.class)
	public void testValidateLineItemTypeWithNullLineItemType() throws Exception{
		LineItem lineItem = new LineItem();
		
		LineItemType lineItemType = new LineItemType();
		lineItemType.setLineItemType(null);
		
		lineItem.setLineItemType(lineItemType);
		
		target.validateLineItem(lineItem);
	}
	
}
