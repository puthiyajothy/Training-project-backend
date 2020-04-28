package com.internal.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.internal.project.dto.ProjectDto;
import com.internal.project.mapper.ProjectDtoMapper;
import com.internal.project.projectservicesImpl.ProjectServiceImpl;
import com.internal.project.repositories.ProjectRepository;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProjectController {

	private static Logger logger = LogManager.getLogger(ProjectController.class);

	@Autowired
	public ProjectDtoMapper projectDtoMapper;
	
	@Autowired
	public ProjectRepository projectRepo;

	@Autowired
	public ProjectServiceImpl projectserviceimpl;
	
	// Post Mapping For Create a Project
	@PostMapping(value = "/createproject")
	public ResponseEntity<Object> createProject(@Valid @RequestBody ProjectDto projectDto) {
		try {
			projectDtoMapper.saveProjectforMapper(projectDto);
			logger.info("Project created");
		} catch (Exception e) {
			logger.info("Project Controller ---> Error" + e.getMessage());
		}

		return null;
	}

	// Post Mapping For Create a Project
	@GetMapping(value = "/GetAllproject")
	public ResponseEntity<List<ProjectDto>> listproject() {
		try {
			logger.info("Project are listed ");
			return new ResponseEntity<>(projectDtoMapper.getAllProject(), HttpStatus.OK);
		} catch (Exception e) {
			logger.info("Project Controller ---> Error" + e.getMessage());
		}
		return null;

	}

	// Get Mapping For Get Project By Id
	@GetMapping("/getProjectById/{projectId}")
	public ResponseEntity<ProjectDto> getProjectById(@PathVariable Long projectId) {
		try {
			logger.info("Projects are get by id ");
			return  new ResponseEntity<>(projectDtoMapper.getByProjectId(projectId), HttpStatus.OK);

		} catch (Exception e) {
			logger.info("Project Controller ---> Error" + e.getMessage());
		}
		return null;
	}

	// Delete project
	@DeleteMapping("deleteById/{projectid}")
	public ResponseEntity<String> deleteproject(@PathVariable("projectid")  Long projectId) {
		try {
			logger.info("Already deleted ");
			projectRepo.deleteById(projectId);
//			projectDtoMapper.delete(projectId);
			return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);

		} catch (Exception e) {
			logger.info("Project Controller ---> Error" + e.getMessage());
		}
		return null;

	}

	// Put Mapping For Project
	@PutMapping("/updateProject/{projectId}")
	public ResponseEntity<String> updateProject(@RequestBody ProjectDto projectDto){
		try {
			logger.info("Projectcontroller -> updatedproject");
			if (projectDtoMapper.UpdateProject(projectDto) != null);
			return new ResponseEntity<>("ok", HttpStatus.OK);

		} catch (Exception e) {
			logger.info("Project Controller ---> Error" + e.getMessage());
		}
		return null;
	}

	// Get Mapping For Project Name
	@GetMapping("/getName/{name}")
	public List<ProjectDto> getByprojectName(@PathVariable String name) {
		try {
			logger.info("Projects are get by name ");
			return projectDtoMapper.getByprojectNameForMapper(name);
		} catch (Exception e) {
			logger.info("Project Controller ---> Error" + e.getMessage());
		}
		return null;

	}

	@GetMapping("/gettype/{type}")
	public List<ProjectDto> getBytype(@PathVariable String type) {
		try {
			logger.info("Projects are get by type");
			return projectDtoMapper.getByProjecttype(type);

		} catch (Exception e) {
			logger.info("Project Controller ---> Error" + e.getMessage());
		}

		return null;

	}

	// Get Mapping For Project Start Date
	@GetMapping("/getDate/{date}")
	public List<ProjectDto> getBystartDate(@PathVariable String date) {
		try {
			logger.info("Projects are get by date ");
			return projectDtoMapper.getBystartDateformapper(date);

		} catch (Exception e) {
			logger.info("Project Controller ---> Error" + e.getMessage());

		}
		return null;

	}

	// Get Mapping For Project duration
	@GetMapping("/getduration/{duration}")
	public List<ProjectDto> getByduration(@PathVariable Long duration) {
		try {
			logger.info("Projects are get by duration");
			return projectDtoMapper.getBydurationformapper(duration);

		} catch (Exception e) {
			logger.info("Project Controller ---> Error" + e.getMessage());
		}
		return null;

	}

	// Get Mapping For Project Status
	@GetMapping("/getstatus/{status}")
	public List<ProjectDto> getBystatus(@PathVariable String status) {
		try {
			logger.info("Projects are get by status");
			return projectDtoMapper.getBystatusformapper(status);

		} catch (Exception e) {
			logger.info("Project Controller ---> Error" + e.getMessage());
		}
		return null;

	}
	
	@GetMapping("/Totalproject")
	public ResponseEntity<Integer> totalprojct(){
		projectserviceimpl.TotalCount();
		return null;	
	}
	

}
