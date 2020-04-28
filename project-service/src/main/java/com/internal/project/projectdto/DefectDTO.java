package com.internal.project.projectdto;

import java.sql.Date;

public class DefectDTO {
	private Long defid;
	private String defectId;
	private String abbre;
	private String priority;
	private String severity;
	private String type;
	private String status;
	private String defectDescription;
	private String stepsToRecreate;
	private String assignTo;
	private String reassignTo;
	private String enteredBy;
	private String fixedBy;
	private String availableIn;
	private String foundIn;
	private String fixedIn;
	private Date dateAndTime;
	private Long pid;
	private String projectId;
	private String projectName;
	private Long mid;
	private String moduleId;
	private String moduleName;
	

	
	public String getDefectId() {
		return defectId;
	}
	public void setDefectId(String defectId) {
		this.defectId = defectId;
	}
	public String getAbbre() {
		return abbre;
	}
	public void setAbbre(String abbre) {
		this.abbre = abbre;
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
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
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
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public Long getMid() {
		return mid;
	}
	public void setMid(Long mid) {
		this.mid = mid;
	}
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public Long getDefid() {
		return defid;
	}
	public void setDefid(Long defid) {
		this.defid = defid;
	}
	
	
	
}
