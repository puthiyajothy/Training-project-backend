package com.internal.project.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.internal.project.project.entities.Project;
import com.internal.project.project.entities.ProjectPrivilegeConfig;
import com.internal.project.project.repositories.ProjectPrivilegeConfigRepository;
import com.internal.project.project.repositories.ProjectRepository;
import com.internal.project.project.services.ProjectService;

@Service
public abstract class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private ProjectPrivilegeConfigRepository projectPrivilegeConfigRepository;

	@Override
	public Project createProject(Project project) {
		Project responseProject = projectRepository.save(project);
		
		Project projObj = new Project();
		projObj.setProjectId(project.getProjectId());
		ProjectPrivilegeConfig projectPrivilegeConfig = new ProjectPrivilegeConfig(projObj);
				projectPrivilegeConfigRepository.save(projectPrivilegeConfig);
		return responseProject;
	}


	@Override
	public boolean isProjectAlreadyExists(Long pid) {
		return projectRepository.existsById(pid);
	}

	@Override
	public List<Project> getallDetails() {
		return projectRepository.findAll();
	}

	@Override
	public Project getByprojectId(Long pid) {
		return projectRepository.getByprojectId(pid);
	}

	@Override
	public List<Project> getByprojectName(String name) {
		return projectRepository.getByprojectName(name);
	}

	@Override
	public List<Project> getBytype(String type) {
		return projectRepository.getBytype(type);
	}

	@Override
	public List<Project> getByduration(Long duration) {
		return projectRepository.getByduration(duration);
	}

	@Override
	public List<Project> getBystatus(String status) {
		return projectRepository.getBystatus(status);
	}

	@Override
	public Project updateProject(Long pid, Project project) {
		if (projectRepository.findAll() != null) {
			project.setPid(pid);
			projectRepository.save(project);
		}
		return project;
	}

	@Override
	public void delete(Long pid) {
		projectRepository.deleteById(pid);
	}

	@Override
	public List<Project> getBystartDate(String date) {
		return projectRepository.getBystartDate(date);
	}


}