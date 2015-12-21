package com.catalyst.tla_expense.services;

import java.util.List;

import com.catalyst.tla_expense.entities.Report;

public interface ReportService {
	
	/**
	 * Retrieves a single report by id
	 * @param id
	 * @return a single report
	 */
	public Report getReport(int id);
	
	/**
	 * Retrieves all the reports in the database
	 * @return List<report> of all reports
	 */
	public List<Report> getAllReports();
	
	/**
	 * Adds a new report that's been created to the database
	 * @param report added to database
	 * @return 
	 * @throws Exception 
	 */
	public int createReport(Report report);
}
