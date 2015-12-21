package com.catalyst.tla_expense.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity (name = "project")
public class Project {
	
	/**
	 * Generates the project_id which is the primary key
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project_id")
	private int projectId;
	
	/**
	 * Required field for the project name
	 */
	@NotNull
	@Column(name = "project_name", unique = true, length = 255)
	private String projectName;
	
	@Column(name = "description", length = 255)
	private String description;
	
	/**
	 * Generates a date when a new project is created
	 */
	@Column(name="create_date", columnDefinition="DATE")
	@JsonFormat(pattern = "MM/dd/yyyy", timezone="PST")
	private Date createDate = new Date();

	/**
	 * Links the user table by user id
	 */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "approver_id", referencedColumnName="user_id")
	private User user;

	/**
	 * Getters and Setters
	 * @return
	 */
	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
