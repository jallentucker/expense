package com.catalyst.tla_expense.services.impl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.catalyst.tla_expense.daos.ReportDao;
import com.catalyst.tla_expense.entities.Report;
import com.catalyst.tla_expense.entities.Status;
import com.catalyst.tla_expense.services.impl.ReportServiceImpl;

public class ReportServiceImplTest {

	private ReportServiceImpl target;
	private ReportDao mockReportDao;
	
	@Before 
	public void setup() {
		target = new ReportServiceImpl();
		mockReportDao = mock(ReportDao.class);
		target.setReportDao(mockReportDao);
	}
	
	@Test
	public void testAddReportWithValidReport() {
		Report report = new Report();
		report.setReportName("Test Report");
		
		target.createReport(report);
		verify(mockReportDao, times(1)).createReport(report);
	}
	
	public void testToVerifyApprovedDateGetsSetWhenStatusChangedToApproved()
	{
		
		Report report = new Report();
		Status status = new Status();
		report.setReportName("Test Report Test Report");
		status.setStatusType("approved");
		
	
		
		Date approvedDate = report.getApprovedDate();
		Date expected = new Date();
		
		target.editReport(report);
		System.out.println(expected + " & " + approvedDate);
		assertEquals(expected, approvedDate);
	}	
	
	/**
	 * Tests that getAllReports() calls the dao method of the same name
	 */
	@Test
	public void testGetAllReports() {
		target.setReportDao(mockReportDao);
		List<Report> expected = new ArrayList<>();
		when(mockReportDao.getAllReports()).thenReturn(expected);
		List<Report> actual = target.getAllReports();
		assertEquals(expected, actual);
	}
	
	/**
	 * Tests that getReport() calls the dao method of the same name
	 */
	@Test
	public void testGetReport() {
		target.setReportDao(mockReportDao);
		Report expected = new Report();
		when(mockReportDao.getReport(anyInt())).thenReturn(expected);
		Report actual = target.getReport(2);
		assertEquals(expected, actual);
	}
}
