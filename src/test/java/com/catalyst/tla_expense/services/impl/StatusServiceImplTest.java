package com.catalyst.tla_expense.services.impl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import com.catalyst.tla_expense.daos.StatusDao;
import com.catalyst.tla_expense.entities.Report;
import com.catalyst.tla_expense.entities.Status;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

public class StatusServiceImplTest {
	private StatusServiceImpl target;
	private StatusDao mockStatusDao;
	
	@Before
	public void setup() {
		target = new StatusServiceImpl();
		mockStatusDao = mock(StatusDao.class);
	}
	
	/**
	 * Tests that getStatuses() calls the dao method of the same name
	 */
	@Test
	public void testThatStatusEntitiesExist() {
		target.setStatusDao(mockStatusDao);
		List<Status> expected = new ArrayList<>();
		when(mockStatusDao.getStatuses()).thenReturn(expected);
		List<Status> actual = target.getStatuses();
		assertEquals(expected, actual);
	}
	
	/**
	 * Tests that getStatusById() calls the dao method of the same name
	 */
	@Test
	public void testThatGetStatusByIdWorks() {
		target.setStatusDao(mockStatusDao);
		Status expected = new Status();
		when(mockStatusDao.getStatusById(anyInt())).thenReturn(expected);
		Status actual = target.getStatusById(2);
		assertEquals(expected, actual);
	}
}
