package com.catalyst.tla_expense.service_test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Date;

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
	
	@Test
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
}
