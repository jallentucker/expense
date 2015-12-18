package com.catalyst.tla_expense.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Project imports
import com.catalyst.tla_expense.entities.Report;
import com.catalyst.tla_expense.services.ReportService;

import com.catalyst.tla_expense.utility.EndpointConstants;

@RestController
public class ReportController {
	
	@Autowired
	private ReportService reportService;
	
	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}
	
	/**
	 * Retrieves a single report by id
	 * @param id
	 * @return a single report
	 */
	@RequestMapping(value = EndpointConstants.REPORT_ENDPOINT+"/{id}", method = RequestMethod.GET)
	public Report getReport(@PathVariable int id) {
		return reportService.getReport(id);
	}
	
	/**
	 * Retrieves all the reports in the database
	 * @return List<report> of all reports
	 */
	@RequestMapping(value = "/getAllReports", method = RequestMethod.GET)
	public List<Report> getAllReports(){
		return reportService.getAllReports();
	}
	
	/**
	 * Adds a new report that's been created to the database
	 * @param report added to database
	 * @throws Exception 
	 * @return 
	 */
	@RequestMapping(value = EndpointConstants.REPORT_ENDPOINT, method = RequestMethod.POST)
	public int addReport(@RequestBody Report report) {
		return this.reportService.createReport(report);
	}
	
	/**
	 * Deletes a report from the database 
	 * @param id 
	 */
	@RequestMapping(value = EndpointConstants.REPORT_ENDPOINT+"/{id}", method = RequestMethod.DELETE)
	public void deleteReport(@PathVariable int id){
		reportService.deleteReport(id);
	}
	
	/**
	 * Updates a report from the database
	 * @param report updated in database
	 */
	@RequestMapping(value = EndpointConstants.REPORT_ENDPOINT+"/{id}", method = RequestMethod.PUT)
	public void editReport(@RequestBody Report report){
		this.reportService.editReport(report);
	}
}
