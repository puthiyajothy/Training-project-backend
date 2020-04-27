package com.training.internal.project.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.internal.project.project.entities.ProjectPrivilegeConfig;

public interface ProjectPrivilegeConfigRepository extends JpaRepository<ProjectPrivilegeConfig, Long> {
	ProjectPrivilegeConfig findProjectPrivilegeConfigByProjectConfigId(Long projectConfigId);
	
//	String UPDATE_PRIVILEGE_CONFIG = "UPDATE defectservices.project_config SET project_config_status = ?1 WHERE project_config_id = ?2";
//	ProjectPrivilegeConfig savePrivilegeConfig(ProjectPrivilegeConfig privilegeConfig);
}
