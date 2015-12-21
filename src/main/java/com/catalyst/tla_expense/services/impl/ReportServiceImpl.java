package com.catalyst.tla_expense.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.catalyst.tla_expense.daos.ReportDao;
import com.catalyst.tla_expense.entities.Report;
import com.catalyst.tla_expense.services.ReportService;

@Service
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	private ReportDao reportDao;
	
	/**
	 * Retrieves a single report by id
	 * @param id
	 * @return a single report
	 */	
	@Override
	public Report getReport(int id) {
		return reportDao.getReport(id);
	}
	
	/**
	 * Retrieves all the reports in the database
	 * @return List<report> of all reports
	 */
	@Override
	public List<Report> getAllReports() {
		return reportDao.getAllReports();
	}

	/**
	 * Adds a new report that's been created to the database
	 * @param report added to database
	 * @return 
	 */
	@Override
	public int createReport(Report report) {
		
		String reportName = report.getReportName();
		
		/**
		 * Checks to see if the entered report name is greater
		 * than 3 characters and there's no whitespace.
		 */
		if(reportName.trim().length() > 2)
		{
			report.setReportName(reportName);
			return this.reportDao.createReport(report);
		}
		else{
			System.out.println("Report name doesn't meet requirements.");
			return 0;
		}
	}

	public void setReportDao(ReportDao reportDao) {
		this.reportDao = reportDao;
	}
	
}
