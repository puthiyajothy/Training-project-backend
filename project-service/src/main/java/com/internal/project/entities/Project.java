package com.internal.project.entities;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(schema = "projectservice", name = "project")
public class Project implements Serializable {

	LocalDate todayDate = LocalDate.now();
	java.sql.Date currentDay = java.sql.Date.valueOf(todayDate);
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long projectId;

	@NotEmpty
	@Size(min = 2, max = 50)
	@Pattern(regexp = "[a-z-A-Z]*", message = "Project Name can not contain invalid characters")
	@Column(name = "project_name")
	private String projectName;

	@NotEmpty
	@Size(min = 2, max = 20)
	@Pattern(regexp = "[a-z-A-Z]*", message = "Project Type can not contain invalid characters")
	@Column(name = "type")
	private String type;

	@DateTimeFormat(iso = ISO.DATE)
	private Date startDate = currentDay;

	@DateTimeFormat(iso = ISO.DATE)
	private Date endDate = currentDay;

	@Column(name = "duration")
	private Long duration;

	@NotEmpty
	@Size(min = 2, max = 10)
	@Pattern(regexp = "[a-z-A-Z]*", message = "Project Status can not contain invalid characters")
	@Column(name = "status")
	private String status;

//	Getters and setters for project 

	public String getProjectName() {
		return projectName;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;

	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = currentDay;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = currentDay;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
