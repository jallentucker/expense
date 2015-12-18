package com.catalyst.tla_expense.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name = "report")
public class Report {
	
	/**
	 * Generates the report_id which is the primary key
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "report_id")
	private int reportId;
	
	/**
	 * Required field to add a unique report name.
	 */
	@NotNull
	@Column(name = "report_name", unique=true, length=150)
	private String reportName;
	
	/**
	 * Generates a time stamp for when the report is submitted
	 */
	@Column (name="report_date", columnDefinition="DATE")
	@JsonFormat(pattern = "MM/dd/yyyy", timezone="PST")
	private Date reportDate = new Date();
	
	/**
	 * Joins the report table with the user table via user_id
	 */
	@NotNull
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	/**
	 * Joins the report table with the project table via project_id
	 */
	@ManyToOne
	@JoinColumn(name="project_id")
	private Project project;

	/**
	 * Joins the report table with the status table via status_id
	 */
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	@JoinColumn(name="status_id")
	private Status status;

	/**
	 * Getters and setters
	 */
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}	
}
