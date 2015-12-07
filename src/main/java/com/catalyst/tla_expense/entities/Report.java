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

@Entity(name = "reports")
public class Report {
	
	/**
	 * Generates the report_id which is the primary key
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "report_id")
	private int reportId;
	
	/**
	 * Joines the report table with the user table via user_id
	 */
	@NotNull
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	
	/**
	 * Joins the report table with the project table via project_id
	 */
//	@NotNull
//	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
//	@JoinColumn(name="project_id")
//	private Project project;
//	
//	
	/**
	 * Joins the report table with the status table via status_id
	 */
//	@NotNull
//	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
//	@JoinColumn(name="status_id")
//	private Status status;
	
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
	 * Placeholder to add the date a report was approved
	 */
	@Column(name="approved_date")
	@JsonFormat(pattern = "MM/dd/yyyy", timezone="PST")
	private Date approvedDate = new Date();
	
	/**
	 * Generates a timestamp for when the report is submitted
	 */
	@NotNull
	@Column (name="report_date", columnDefinition="DATE")
	@JsonFormat(pattern = "MM/dd/yyyy", timezone="PST")
	private Date reportDate;
	
	
	public Report() {
		super();
		this.user = null;
		//this.project = null;
		//this.status = "saved";
		this.rejectReason = null;
		this.reportNotes = null;
		this.approvedDate = null;
		this.reportDate = null;
	}
	
	public Report(User user, /*Project project, Status status,*/ String rejectReason,
			String reportNotes, Date approvedDate, Date reportDate) {
		super();
		this.user = null;
		//this.project = null;
		//this.status = "saved";
		this.rejectReason = null;
		this.reportNotes = null;
		this.approvedDate = null;
		this.reportDate = null;
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
}
