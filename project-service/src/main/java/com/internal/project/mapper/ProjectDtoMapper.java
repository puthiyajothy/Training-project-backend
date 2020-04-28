package com.internal.project.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.internal.project.converter.ProjectConverter;
import com.internal.project.dto.ProjectDto;
import com.internal.project.entities.Project;
import com.internal.project.projectservicesImpl.ProjectServiceImpl;

@Service
public class ProjectDtoMapper {
	
//	@Autowired
//	public ProjectService projectServiceimpl;

	@Autowired
	public ProjectServiceImpl projectimpl;
	
//	List All Project 
	public List<ProjectDto> getAllProject() {
		List<Project> projectList = projectimpl.getallDetails();
		return ProjectConverter.projectToProjectDto(projectList);

	}

//	save project
	public Project saveProjectforMapper(ProjectDto projectDto) {
		Project project = ProjectConverter.projectDtoToProject(projectDto);
		return projectimpl.createProject(project);
	}

	public ProjectDto getByProjectId(Long projectId) {
		Project project = projectimpl.getByprojectId(projectId);
		return ProjectConverter.projectToProjectDto(project);
	}

	public List<ProjectDto> getByprojectNameForMapper(String projectName) {
		List<Project> project = projectimpl.getByprojectName(projectName);
		return ProjectConverter.projectToProjectDto(project);
	}

	public List<ProjectDto> getByProjecttype(String type) {
		List<Project> project = projectimpl.getBytype(type);
		return ProjectConverter.projectToProjectDto(project);
	}

	public List<ProjectDto> getBystartDateformapper(String date) {
		List<Project> project = projectimpl.getBystartDate(date);
		return ProjectConverter.projectToProjectDto(project);
	}

	public List<ProjectDto> getBydurationformapper(Long duration) {
		List<Project> project = projectimpl.getByduration(duration);
		return ProjectConverter.projectToProjectDto(project);
	}

	public List<ProjectDto> getBystatusformapper(String status) {
		List<Project> project = projectimpl.getBystatus(status);
		return ProjectConverter.projectToProjectDto(project);
	}

	public Project UpdateProject(ProjectDto projectDto) {
		Project project = ProjectConverter.projectDtoToProject(projectDto);
		return projectimpl.updateProject(project);
	}

	public ProjectDto delete(Long projectId) {
		projectimpl.delete(projectId);
		return null;

	}

}
