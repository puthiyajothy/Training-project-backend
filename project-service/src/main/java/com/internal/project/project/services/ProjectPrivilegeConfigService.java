package com.internal.project.project.services;

import java.util.List;

import com.internal.project.project.entities.ProjectPrivilegeConfig;


public interface ProjectPrivilegeConfigService {
	// Create Project Privilege Configuration
		public ProjectPrivilegeConfig createProjectPrivilegeConfig(ProjectPrivilegeConfig projectPrivilegeConfig);
		// Update Project Privilege Configuration
		public ProjectPrivilegeConfig updateProjectPrivilegeConfig(ProjectPrivilegeConfig projectPrivilegeConfig);
		// Get Project Privilege Configuration By Id
		public ProjectPrivilegeConfig getProjectPrivilegeConfigById(Long projectConfigId);
		// Get All Project Privilege Configuration 
		public List<ProjectPrivilegeConfig> getAllProjectPrivilegeConfig();
		// Delete Project Privilege Configuration Id
		public ProjectPrivilegeConfig deleteProjectPrivilegeConfigById(Long projectConfigId);
}
