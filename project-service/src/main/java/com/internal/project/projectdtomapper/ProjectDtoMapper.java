package com.internal.project.projectdtomapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internal.project.converter.ProjectConverter;
import com.internal.project.project.entities.Project;
import com.internal.project.project.services.ProjectService;
import com.internal.project.projectdto.ProjectDto;
import com.internal.project.services.impl.ProjectServiceImpl;

@Service
public class ProjectDtoMapper {
	@Autowired
	public ProjectServiceImpl projectServiceimpl;

//	List All Project 
	public List<ProjectDto> getAllProject() {
		List<Project> projectList = projectServiceimpl.getallDetails();
		return ProjectConverter.projectToProjectDto(projectList);

	}

//	save project
	public Project saveProjectforMapper(ProjectDto projectDto) {
		Project project = ProjectConverter.projectDtoToProject(projectDto);
		return projectServiceimpl.createProject(project);
	}

	public ProjectDto getByProjectId(Long pid) {
		Project project = projectServiceimpl.getByprojectId(pid);
		return ProjectConverter.projectToProjectDto(project);
	}

	public List<ProjectDto> getByprojectNameForMapper(String projectName) {
		List<Project> project = projectServiceimpl.getByprojectName(projectName);
		return ProjectConverter.projectToProjectDto(project);
	}

	public List<ProjectDto> getByProjecttype(String type) {
		List<Project> project = projectServiceimpl.getBytype(type);
		return ProjectConverter.projectToProjectDto(project);
	}

	public List<ProjectDto> getBystartDateformapper(String date) {
		List<Project> project = projectServiceimpl.getBystartDate(date);
		return ProjectConverter.projectToProjectDto(project);
	}

	public List<ProjectDto> getBydurationformapper(Long duration) {
		List<Project> project = projectServiceimpl.getByduration(duration);
		return ProjectConverter.projectToProjectDto(project);
	}

	public List<ProjectDto> getBystatusformapper(String status) {
		List<Project> project = projectServiceimpl.getBystatus(status);
		return ProjectConverter.projectToProjectDto(project);
	}

	public Project UpdateProject(Long pid, ProjectDto projectDto) {
		Project project = ProjectConverter.projectDtoToProject(projectDto);
		return projectServiceimpl.updateProject(pid, project);
	}

	public ProjectDto delete(Long pid) {
		projectServiceimpl.delete(pid);
		return null;

	}

}
