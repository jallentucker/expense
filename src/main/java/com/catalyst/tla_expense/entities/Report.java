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
	 * Required field to add the timeframe in which reimbursement was 
	 * being recorded
	 */
//	@NotNull
//	@Column(name="time_frame",columnDefinition="DATE")
//	@JsonFormat(pattern = "MM/dd/yyyy", timezone="PST")
//	private 
	/**
	 * Joins the report table with the user table via user_id
	 */
	@NotNull
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	
	/**
	 * Joins the report table with the project table via project_id
	 */
	@NotNull
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	@JoinColumn(name="project_id")
	private Project project;

	/**
	 * Joins the report table with the status table via status_id
	 */
	@NotNull
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	@JoinColumn(name="status_id")
	private Status status;
	
	/**
	 * Placeholder for the approver to add a reject reason so that users
	 * can correct their mistake
	 */
	@Column(name="reject_reason", length=255)
	private String rejectReason;
	
	/**
	 * Placeholder for a user to add notes if they desire
	 */
	@Column(name="notes", length=255)
	private String reportNotes;

	/**
	 * Placeholder to generate the date a report was approved
	 */
	@Column(name="approved_date", columnDefinition="DATE")
	@JsonFormat(pattern = "MM/dd/yyyy", timezone="PST")
	private Date approvedDate;
	
	/**
	 * Generates a time stamp for when the report is submitted
	 */
	@NotNull
	@Column (name="report_date", columnDefinition="DATE")
	@JsonFormat(pattern = "MM/dd/yyyy", timezone="PST")
	private Date reportDate = new Date();
	
	/**
	 * flexible constructor
	 */
	public Report() {
		super();
		this.user = null;
		this.project = null;
		this.rejectReason = null;
		this.reportNotes = null;
		this.approvedDate = null;
		this.reportDate = null;
	}
	
	/**
	 * fully filled constructor
	 * @param user
	 * @param rejectReason
	 * @param reportNotes
	 * @param approvedDate
	 * @param reportDate
	 */
	public Report(User user, Project project, Status status, String rejectReason,
			String reportNotes, Date approvedDate, Date reportDate) {
		super();
		this.user = null;
		this.project = null;
		this.status = status;
		this.rejectReason = null;
		this.reportNotes = null;
		this.approvedDate = null;
		this.reportDate = null;
	}
	
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

	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	public String getReportNotes() {
		return reportNotes;
	}

	public void setReportNotes(String reportNotes) {
		this.reportNotes = reportNotes;
	}

	public Date getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
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
