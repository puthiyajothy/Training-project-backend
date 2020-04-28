package com.internal.project.project.controller;

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

import com.internal.project.project.repositories.ProjectRepository;
import com.internal.project.projectdto.ProjectDto;
import com.internal.project.projectdtomapper.ProjectDtoMapper;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProjectController {

	private static Logger logger = LogManager.getLogger(ProjectRepository.class);

	@Autowired
	public ProjectDtoMapper projectDtoMapper;

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
			projectDtoMapper.getAllProject();

		} catch (Exception e) {
			logger.info("Project Controller ---> Error" + e.getMessage());
		}
		return null;

	}

	// Get Mapping For Get Project By Id
	@GetMapping("/getProjectById/{pid}")
	public ResponseEntity<ProjectDto> getProjectById(@PathVariable Long pid) {
		try {
			logger.info("Projects are get by id ");
			projectDtoMapper.getByProjectId(pid);

		} catch (Exception e) {
			logger.info("Project Controller ---> Error" + e.getMessage());
		}
		return null;
	}

	// Delete Mapping For Project
	@DeleteMapping("deleteById/{pid}")
	public void delete(@PathVariable Long pid) {
		try {
			logger.info("Already deleted ");
			projectDtoMapper.delete(pid);

		} catch (Exception e) {
			logger.info("Project Controller ---> Error" + e.getMessage());
		}

	}

	// Put Mapping For Project
	@PutMapping("/updateProject/{pid}")
	public ResponseEntity<String> updateProject(@Valid @PathVariable(name = "pid") Long pid,
			@RequestBody ProjectDto projectDto) {
		try {
			logger.info("Projectcontroller -> updatedproject");
			if (projectDtoMapper.UpdateProject(pid, projectDto) != null);

		} catch (Exception e) {
			logger.info("Project Controller ---> Error" + e.getMessage());
		}
		return new ResponseEntity<>("ok", HttpStatus.OK);

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

//	@DeleteMapping("/delete/{projectid}") // Delete Employee Using Employee ID
//	public ResponseEntity<String> deleteproject(@PathVariable("projectid") String projectid) {
//		try {
//			logger.info("Project Controller :-> Delete Project");
//			projectDtoMapper.deleteById(projectid);
//			return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
//		} catch (Exception ex) {
//			logger.error("Project Controller :-> Error" + ex.getMessage());
//		}
//		return null;
//	}
}
