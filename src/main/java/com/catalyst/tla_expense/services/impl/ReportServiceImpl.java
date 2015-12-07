package com.catalyst.tla_expense.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	private Object report;
	
	public void setReportDao(ReportDao reportDao) {
		this.reportDao = reportDao;
	}
	
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
	 */
	@Override
	public void createReport(Report report) {		
		this.reportDao.createReport(report);
	}
	
	/**
	 * Edits a selected report and updates it in the database.
	 */
	@Override
	public void editReport(Report report){
		this.reportDao.editReport(report);
	}
}
