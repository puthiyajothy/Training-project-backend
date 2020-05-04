package com.internal.project.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(schema = "projectservice", name = "defect")
public class Defect {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long defid;
	
	@Size(min = 2, max = 50)
	private String defectId;

	private String priority;
	private String severity;
	private String type;
	private String status;

	@ManyToOne
	@JoinColumn(name = "project_id", nullable = false)
	private Project project;

	@ManyToOne
	@JoinColumn(name = "mid", nullable = false)
	private Module module;
	
	
	@NotNull
	@Size(min = 2, max = 500)
	private String defectDescription;

	@NotNull
	@Size(min = 10, max = 500)
	private String stepsToRecreate;

	@NotNull
	@Size(min = 2, max = 50)
	private String assignTo;

	@NotNull
	@Size(min = 2, max = 50)
	private String reassignTo;

	@NotNull
	@Size(min = 2, max = 50)
	private String enteredBy;

	@NotNull
	@Size(min = 2, max = 50)
	private String fixedBy;

	@NotNull
	@Size(min = 2, max = 50)
	private String availableIn;

	@NotNull
	@Size(min = 2, max = 50)
	private String foundIn;

	@NotNull
	@Size(min = 2, max = 50)
	private String fixedIn;

	@NotNull
	@DateTimeFormat(iso = ISO.DATE)
	private Date dateAndTime;

	// Generate getters and Setters
	public String getDefectId() {
		return defectId;
	}

	public void setDefectId(String defectId) {
		this.defectId = defectId;
	}


	public String getDefectDescription() {
		return defectDescription;
	}

	public void setDefectDescription(String defectDescription) {
		this.defectDescription = defectDescription;
	}

	public String getStepsToRecreate() {
		return stepsToRecreate;
	}

	public void setStepsToRecreate(String stepsToRecreate) {
		this.stepsToRecreate = stepsToRecreate;
	}

	public String getAssignTo() {
		return assignTo;
	}

	public void setAssignTo(String assignTo) {
		this.assignTo = assignTo;
	}

	public String getReassignTo() {
		return reassignTo;
	}

	public void setReassignTo(String reassignTo) {
		this.reassignTo = reassignTo;
	}

	public String getEnteredBy() {
		return enteredBy;
	}

	public void setEnteredBy(String enteredBy) {
		this.enteredBy = enteredBy;
	}

	public String getFixedBy() {
		return fixedBy;
	}

	public void setFixedBy(String fixedBy) {
		this.fixedBy = fixedBy;
	}

	public String getAvailableIn() {
		return availableIn;
	}

	public void setAvailableIn(String availableIn) {
		this.availableIn = availableIn;
	}

	public String getFoundIn() {
		return foundIn;
	}

	public void setFoundIn(String foundIn) {
		this.foundIn = foundIn;
	}

	public String getFixedIn() {
		return fixedIn;
	}

	public void setFixedIn(String fixedIn) {
		this.fixedIn = fixedIn;
	}

	public Date getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getDefid() {
		return defid;
	}

	public void setDefid(Long defid) {
		this.defid = defid;
	}

	
}
