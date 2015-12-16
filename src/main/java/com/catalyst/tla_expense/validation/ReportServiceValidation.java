package com.catalyst.tla_expense.validation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.catalyst.tla_expense.daos.ReportDao;
import com.catalyst.tla_expense.entities.Report;


public class ReportServiceValidation {
	
	@Autowired
	private ReportDao reportDao;

	public boolean reportName(Report report) throws Exception{
		boolean result = true;
		try{
			String reportName = report.getReportName().trim();
			if(reportName.equals("") || reportName.length() < 2){
				result = false;
			}
			
			List<Report> existingReports = reportDao.getAllReports();
			
			for(Report r : existingReports){
				String lowerCaseReportName = reportName.toLowerCase();
				String lowerCaseExistingReportName = r.getReportName().toLowerCase();
				if(lowerCaseReportName.equals(lowerCaseExistingReportName)){
					result = false;
				}
			}
			return result;
		}catch(NullPointerException e){
			throw new Exception("Report Name is null");
		}
	}

	public void setReportDao(ReportDao reportDao) {
		this.reportDao = reportDao;
	}
}
