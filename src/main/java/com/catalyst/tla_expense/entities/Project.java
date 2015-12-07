package com.catalyst.tla_expense.entities;

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

import com.catalyst.HobbyCollector.entities.Condition;


@Entity (name = "project")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project_id")
	private int projectId;
	
	@NotNull
	@Column(name = "project_name", unique = true, length = 255)
	private String projectName;
	
	@Column(name = "description", length = 255)
	private String description;
	
	// Link to user table by id
	@NotNull
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	@JoinColumn(name = "approver_id", referencedColumnName="user_id")
	private User user;

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
	
	public User getCondition() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	


}
