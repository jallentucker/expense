package com.catalyst.tla_expense.services.impl;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import static org.mockito.Mockito.mock;
import com.catalyst.tla_expense.daos.LineItemDao;
import com.catalyst.tla_expense.entities.LineItem;

public class LineItemServiceImplTest {

	private LineItemDao mockLineItemDao;
	private LineItemServiceImpl target;
	
	@Before
	public void setup(){
		target = new LineItemServiceImpl();
		mockLineItemDao= mock(LineItemDao.class);
		target.setLineItemDao(mockLineItemDao);
	}
	
	@Test
	public void testGetAllLineItems(){
		target.getAllLineItems();
		verify(mockLineItemDao, times(1)).getAllLineItems();
	}
	
	@Test
	public void testAddLineItem(){
		LineItem lineItem = new LineItem();
		target.addLineItem(lineItem);
		verify(mockLineItemDao, times(1)).addLineItem(lineItem);
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
