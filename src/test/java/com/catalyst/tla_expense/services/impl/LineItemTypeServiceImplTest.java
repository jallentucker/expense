package com.catalyst.tla_expense.services.impl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import com.catalyst.tla_expense.daos.LineItemTypeDao;

public class LineItemTypeServiceImplTest {

	private LineItemTypeServiceImpl target;
	private LineItemTypeDao mockLineItemTypeDao;
	
	@Before
	public void setup(){
		target = new LineItemTypeServiceImpl();
		mockLineItemTypeDao= mock(LineItemTypeDao.class);
		target.setLineItemTypeDao(mockLineItemTypeDao);
	}
	
	@Test
	public void testGetAllLineItemTypes(){
		target.getAllLineItemTypes();
		verify(mockLineItemTypeDao, times(1)).getAllLineItemTypes();
	}
}
