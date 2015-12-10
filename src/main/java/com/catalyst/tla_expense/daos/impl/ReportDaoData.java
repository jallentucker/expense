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
		return em.createQuery("SELECT c FROM Report c WHERE c.id = :id", Report.class)
				.setParameter("id", id)
				.getSingleResult();
	}
	
	/**
	 * Retrieves all the reports in the database
	 * @return List<report> of all reports
	 */
	public List<Report> getAllReports(){
		return em.createQuery("SELECT e FROM Report e ORDER BY e.reportId", Report.class)
				.getResultList();
	}
	
	/**
	 * Adds a new report that's been created to the database
	 * @param report added to database
	 */
	public void createReport(Report report) {
		em.merge(report);
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
