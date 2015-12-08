package com.catalyst.tla_expense.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="status")
public class Status {
	
	/**
	 * Generates the status_id which is the primary key
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "status_id")
	private int statusId;
	
	/**
	 * Set of 5 unique statuses that are injected into the database
	 * upon app launch: Submitted, Approved, Rejected, Saved, and 
	 * Under Review
	 */
	@Column(name="status_type", length=25)
	private String statusType = "saved";

	/**
	 * Getters and Setters
	 */
	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatusType() {
		return statusType;
	}

	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}
}
