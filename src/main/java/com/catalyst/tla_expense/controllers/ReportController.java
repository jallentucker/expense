package com.catalyst.tla_expense.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.catalyst.tla_expense.entities.Report;
import com.catalyst.tla_expense.entities.Status;
import com.catalyst.tla_expense.services.ReportService;

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
	@RequestMapping(value = "/getSingleReport/{id}", method = RequestMethod.GET)
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
	 */
	@RequestMapping(value = "/report/post", method = RequestMethod.POST)
	public void addReport(@RequestBody Report report) {
		this.reportService.createReport(report);
	}
	
	/**
	 * Deletes a report from the database 
	 * @param id 
	 */
	@RequestMapping(value = "/deleteReport/{id}", method = RequestMethod.DELETE)
	public void deleteReport(@PathVariable int id){
		reportService.deleteReport(id);
	}
	
	/**
	 * Updates a report from the database
	 * @param report updated in database
	 */
	@RequestMapping(value = "/editReport/{id}", method = RequestMethod.PUT)
	public void editReport(@RequestBody Report report){
		this.reportService.editReport(report);
	}
	
	@RequestMapping(value="/dummy", method=RequestMethod.GET)
	public void dummyData() {
		
		Report report = new Report();
		Status status = new Status();
		
		report.setReportName("blue");
		status.setStatusType("approved");
		
		this.reportService.createReport(report);
	}
	
}
