package com.catalyst.tla_expense.validation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import com.catalyst.tla_expense.entities.LineItem;
import com.catalyst.tla_expense.entities.LineItemType;
import com.catalyst.tla_expense.entities.Report;

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
		
		Report report = new Report();
		report.setReportId(1);
		
		lineItem.setMonetaryAmount(2.4);
		lineItem.setLineItemType(lineItemType);
		lineItem.setReport(report);
		
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
	
	@Test (expected=Exception.class)
	public void testValidateLineItemWithNotSpecifiedProject() throws Exception{
		LineItem lineItem = new LineItem();
		
		LineItemType lineItemType = new LineItemType();
		lineItemType.setLineItemTypeId(1);
		
		Report report = new Report();
		
		lineItem.setLineItemType(lineItemType);
		lineItem.setReport(report);
		lineItem.setMonetaryAmount(245);
		
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
	
	@Test 
	public void testValidateLineItemProjectWithValidProjectId() throws Exception{
		LineItem lineItem = new LineItem();
		Report report = new Report();
		report.setReportId(1);
		lineItem.setReport(report);
		
		assertTrue(target.validateLineItemProject(lineItem));
	}
	
	@Test (expected=Exception.class)
	public void testValidateLineItemProjectWithInvalidProjectId() throws Exception{
		LineItem lineItem = new LineItem();
		Report report = new Report();
		report.setReportId(0);
		lineItem.setReport(report);
		
		target.validateLineItemProject(lineItem);
	}
	
	@Test (expected=Exception.class)
	public void testValidateLineItemProjectWithNotSpecifiedProjectId() throws Exception{
		LineItem lineItem = new LineItem();
		Report report = new Report();
		lineItem.setReport(report);
		
		target.validateLineItemProject(lineItem);
	}
	
}
