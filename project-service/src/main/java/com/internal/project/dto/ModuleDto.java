package com.internal.project.dto;

import org.springframework.stereotype.Component;

@Component
public class ModuleDto {

	private Long mid;
	private String moduleId;
	private String moduleName;
	private Long projectid;
	private String projectName;

	public ModuleDto() {
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public ModuleDto(Long mid, String moduleId, String moduleName) {
		super();
		this.mid = mid;
		this.moduleId = moduleId;
		this.moduleName = moduleName;
	}

	public Long getMid() {
		return mid;
	}

	public void setMid(Long mid) {
		this.mid = mid;
	}

	public Long getProjectid() {
		return projectid;
	}

	public void setProjectid(Long projectid) {
		this.projectid = projectid;
	}

	// getters setters for module DTO
	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;

	}

	// getter setter for submodule id
//	public String getSubModuleId() {
//		return subModuleId;
//	}
//
//	public void setSubModuleId(String subModuleId) {
//		this.subModuleId = subModuleId;
//	}
//
//	public String getSubModuleName() {
//		return subModuleName;
//	}
//
//	public void setSubModuleName(String subModuleName) {
//		this.subModuleName = subModuleName;
//	}
//
//	// getters setters for project id

}
