package com.internal.project.dto;

public class ProjectPrivilegeConfigDto {
	private Long projectConfigurationId;
	private Long projectId;
	private String projectName;
	private boolean projectConfigurationStatus;

	public Long getProjectConfigurationId() {
		return projectConfigurationId;
	}

	public void setProjectConfigurationId(Long projectConfigurationId) {
		this.projectConfigurationId = projectConfigurationId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public boolean isProjectConfigurationStatus() {
		return projectConfigurationStatus;
	}

	public void setProjectConfigurationStatus(boolean projectConfigurationStatus) {
		this.projectConfigurationStatus = projectConfigurationStatus;
	}

}
