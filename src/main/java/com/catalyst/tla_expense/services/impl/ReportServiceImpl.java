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
	 * Deletes a report from the database 
	 * @param id 
	 */
	@Override
	public void deleteReport(int id) {
		this.reportDao.deleteReport(id);	
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
			reportName.toLowerCase();
			report.setReportName(reportName);
			return this.reportDao.createReport(report);
		}
		else{
			System.out.println("Report name doesn't meet requirements.");
			return 0;
		}
	}
	
	/**
	 * Edits a selected report and updates it in the database.
	 */
	@Override
	public void editReport(Report report){
		
		//String statusType = status.getStatusType();
		String reportName = report.getReportName();
		
		/**
		 * Checks to see if the entered report name is greater
		 * than 3 characters and there's no whitespace.
		 */
		if(reportName.trim().length() > 3)
		{
			reportName.toLowerCase();
			report.setReportName(reportName);
		} else {
			System.out.println("Report name doesn't meet requirements.");
		}
		
//		/**
//		 * Checks to see what the status is set to and if it is approved, then
//		 * generate an approved date and store it.
//		 */
//		if(statusType.equals("approved"))
//		{
//			report.setApprovedDate(new Date());
//		}
//		this.reportDao.editReport(report);
	}
	public void setReportDao(ReportDao reportDao) {
		this.reportDao = reportDao;
	}
	
}
