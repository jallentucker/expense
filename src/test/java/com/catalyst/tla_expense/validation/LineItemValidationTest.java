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
		lineItemType.setLineItemTypeId(1);
		
		lineItem.setMonetaryAmount(2.4);
		lineItem.setLineItemType(lineItemType);
		
		assertTrue(target.validateLineItem(lineItem));
	}
	
	@Test (expected=Exception.class)
	public void testValidateLineItemWithInvalidMonetaryAmount() throws Exception{
		LineItem lineItem = new LineItem();
		
		LineItemType lineItemType = new LineItemType();
		lineItemType.setLineItemTypeId(1);
		
		lineItem.setLineItemType(lineItemType);
		lineItem.setMonetaryAmount(0);
		
		assertFalse(target.validateLineItem(lineItem));
	}
	
	@Test (expected=Exception.class)
	public void testValidateLineItemWithNullLineItemType() throws Exception{
		LineItem lineItem = new LineItem();
		
		LineItemType lineItemType = new LineItemType();
		
		lineItem.setLineItemType(lineItemType);
		lineItem.setMonetaryAmount(2.35);
		
		target.validateLineItem(lineItem);
	}
	
	@Test (expected=Exception.class)
	public void testValidateLineItemWithNullLineItemTypeAndNullMonetaryAmount() throws Exception{
		LineItem lineItem = new LineItem();
		
		LineItemType lineItemType = new LineItemType();
		
		lineItem.setLineItemType(lineItemType);
		
		target.validateLineItem(lineItem);
	}
	
	@Test
	public void testValidateLineItemTypeWithValidLineItemType() throws Exception{
		LineItem lineItem = new LineItem();
		
		LineItemType lineItemType = new LineItemType();
		lineItemType.setLineItemTypeId(1);
		lineItem.setLineItemType(lineItemType);
		
		assertTrue(target.validateLineItemType(lineItem));
	}
	
	@Test (expected=Exception.class)
	public void testValidateLineItemTypeWithInvalidMonetaryAmount() throws Exception{
		LineItem lineItem = new LineItem();
		
		lineItem.setMonetaryAmount(0);
		
		target.validateLineItemType(lineItem);
	}
	
	@Test (expected=Exception.class)
	public void testValidateLineItemTypeWithLineItemTypeThatDoesNotExist() throws Exception{
		LineItem lineItem = new LineItem();
		
		LineItemType lineItemType = new LineItemType();
		
		lineItem.setLineItemType(lineItemType);
		
		target.validateLineItem(lineItem);
	}
	
}
