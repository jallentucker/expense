package com.catalyst.tla_expense.services.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import com.catalyst.tla_expense.daos.LineItemDao;
import com.catalyst.tla_expense.entities.LineItem;
import com.catalyst.tla_expense.validation.LineItemValidation;

public class LineItemServiceImplTest {

	private LineItemValidation mockLineItemValidation;
	private LineItemDao mockLineItemDao;
	private LineItemServiceImpl target;
	
	@Before
	public void setup(){
		target = new LineItemServiceImpl();
		mockLineItemDao= mock(LineItemDao.class);
		mockLineItemValidation = mock(LineItemValidation.class);
		target.setLineItemDao(mockLineItemDao);
		target.setLineItemValidation(mockLineItemValidation);
	}
	
	@Test
	public void testGetAllLineItems(){
		target.getAllLineItems();
		verify(mockLineItemDao, times(1)).getAllLineItems();
	}
	
	@Test
	public void testAddLineItemWhenValid() throws Exception{
		LineItem lineItem = new LineItem();
		when(mockLineItemValidation.validateLineItem(lineItem)).thenReturn(true);
		Assert.assertTrue(target.addLineItem(lineItem) >= 0);
	}
	
	@Test
	public void testAddLineItemWhenInvalid() throws Exception{
		LineItem lineItem = new LineItem();
		when(mockLineItemValidation.validateLineItem(lineItem)).thenReturn(false);
		Assert.assertFalse((target.addLineItem(lineItem)) >= 0);
	}
	
	@Test
	public void testUpdateLineItem(){
		LineItem lineItem = new LineItem();
		target.updateLineItem(lineItem);
		verify(mockLineItemDao, times(1)).updateLineItem(lineItem);
	}
	
	@Test
	public void testDeleteLineItemById(){
		target.deleteLineItemById(1);
		verify(mockLineItemDao, times(1)).deleteLineItemById(1);
	}
}
