package com.internal.project.projectservicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.internal.project.entities.Project;
import com.internal.project.repositories.ProjectRepository;
import com.internal.project.services.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public Project createProject(Project project) {
		projectRepository.save(project);
		return null;
	}


	@Override
	public boolean isProjectAlreadyExists(Long projectId) {
		return projectRepository.existsById(projectId);
	}

	@Override
	public List<Project> getallDetails() {
		return projectRepository.findAll();
	}

	@Override
	public Project getByprojectId(Long projectId) {
		return projectRepository.getByprojectId(projectId);
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
	public Project updateProject(Project project) {
		Long projectId = project.getProjectId();
		boolean isExist = projectRepository.getByprojectId(projectId)!=null;
		if (isExist) {
			projectRepository.save(project);
		}
		return null;
	}

	@Override
	public void delete(Long projectId) {
		projectRepository.deleteById(projectId);
	}

	@Override
	public List<Project> getBystartDate(String date) {
		return projectRepository.getBystartDate(date);
	}


	@Override
	public Long TotalCount() {
		projectRepository.count();
		return null;
	}
}
