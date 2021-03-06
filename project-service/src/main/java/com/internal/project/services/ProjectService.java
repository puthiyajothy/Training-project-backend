package com.internal.project.services;

import java.util.List;

import com.internal.project.entities.Project;


public interface ProjectService {

	// Method for Save Project Entity
	public Project createProject(Project project);

	// Method for Exists Project Entity
	public boolean isProjectAlreadyExists(Long projectId);

	// Method for Get all Project Entity
	public List<Project> getallDetails();

	// Method for Delete Project Entity
	public void delete(Long projectId);

	// Method for Update Project Entity
	public Project updateProject(Project project); 

	// Method for GetProjectId in Project Entity
	public Project getByprojectId(Long projectId);

	// Method for GetProjectName in Project Entity
	public List<Project> getByprojectName(String name);

	// Method for GetProjectType in Project Entity
	public List<Project> getBytype(String type);

	// Method for GetProjectStartDate in Project Entity
	public List<Project> getBystartDate(String date);

	// Method for GetProjectDuration in Project Entity
	public List<Project> getByduration(Long duration);

	// Method for GetProjectStatus in Project Entity
	public List<Project> getBystatus(String status);
	
	//Count project
	public Long TotalCount();


}
