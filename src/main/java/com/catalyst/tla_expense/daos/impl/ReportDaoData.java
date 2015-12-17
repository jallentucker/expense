package com.catalyst.tla_expense.daos.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.catalyst.tla_expense.daos.ReportDao;
import com.catalyst.tla_expense.entities.Report;

@Repository
@Transactional
public class ReportDaoData implements ReportDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	/**
	 * Retrieves a single report by id
	 * @param id
	 * @return a single report
	 */
	public Report getReport(int id) {
		return em.createQuery("SELECT c FROM report c WHERE c.id = :id", Report.class)
				.setParameter("id", id)
				.getSingleResult();
	}
	
	/**
	 * Retrieves all the reports in the database
	 * @return List<report> of all reports
	 */
	@Override
	public List<Report> getAllReports(){
		return em.createQuery("SELECT e FROM report e ORDER BY e.reportId", Report.class)
				.getResultList();
	}
	
	/**
	 * Adds a new report that's been created to the database ORDER BY e.reportId
	 * @param report added to database
	 * @return 
	 */
	public int createReport(Report report) {
		em.merge(report);
		Report reportReturn = em.createQuery("SELECT r FROM report r WHERE r.reportName = :reportName AND r.project = :projectId", Report.class)
		.setParameter("reportName", report.getReportName())
		.setParameter("projectId", report.getProject())
		.getSingleResult();
		return reportReturn.getReportId();

	}
	
	/**
	 * Deletes a report from the database 
	 * @param id 
	 */
	public void deleteReport(int id) {
		em.remove(id);
	}
	
	/**
	 * Updates a report in the database
	 * @param report
	 */
	public void editReport(Report report) {
		em.merge(report);
	}
	
	/**
	 * verifies if a report with the given name exists in the database
	 * @param reportName
	 * @return
	 */
	public boolean inList(String reportName)
	{
		
		List<Report> reportList = getAllReports();
		for(Report i: reportList)
		{
			if((i.getReportName()).equals(reportName))
			{
				return true;
			}
		}
		return false;
	}
	
	
}
