package com.internal.project.dto;

public class ResourceAllocationDto {

	
//	<---Initialize Variable for Attribute of Resource Allocation DTO--->
	private Long resourceId;
//	private String resourceName;
	private String projectName;
	private Long projectid;
	private Long empId;
	private String employeeid;
	private String name;
	private String firstname;
	private String email;
	private Long designationid;
	private String designationname;
	
	
//	<--- Resource Allocation DTO--- Getter Setter --->
	public Long getResourceId() {
		return resourceId;
	}
	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public String getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getDesignationid() {
		return designationid;
	}
	public void setDesignationid(Long designationid) {
		this.designationid = designationid;
	}
	public String getDesignationname() {
		return designationname;
	}
	public void setDesignationname(String designationname) {
		this.designationname = designationname;
	}
	public Long getProjectid() {
		return projectid;
	}
	public void setProjectid(Long projectid) {
		this.projectid = projectid;
	}
	
	
	
	
	
}
