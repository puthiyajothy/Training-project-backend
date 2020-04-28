package com.internal.project.dto;

import org.springframework.stereotype.Component;

@Component
public class ModuleData {

	private String moduleId;
	private String moduleName;
	private Long projectId;
//	private String subModuleId;
//	private String subModuleName;

	public ModuleData(String moduleId, String moduleName) {
		super();
		this.moduleId = moduleId;
		this.moduleName = moduleName;
	}

	public ModuleData() {
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
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
