package com.catalyst.tla_expense.daos;

import java.util.List;

import com.catalyst.tla_expense.entities.Report;


public interface ReportDao {

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
	 */
	public void createReport(Report report);
	
	/**
	 * Deletes a report from the database 
	 * @param id 
	 */
	public void deleteReport(int id);
	
	/**
	 * Updates a report in the database
	 * @param report
	 */
	public void editReport(Report report);
	
	/**
	 * verifies if a report with the given name exists in the database
	 * @param reportName
	 * @return
	 */
	public boolean inList(String reportName);
}
