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
	 * Deletes a report from the database 
	 * @param id 
	 */
	public void deleteReport(int id);
	
	/**
	 * Adds a new report that's been created to the database
	 * @param report added to database
	 */
	public void createReport(Report report);
	
	/**
	 * Edits a selected report and updates it in the database.
	 */
	void editReport(Report report);
	

}
