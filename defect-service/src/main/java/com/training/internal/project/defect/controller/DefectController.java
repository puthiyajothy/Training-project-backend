package com.training.internal.project.defect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.internal.project.defect.controller.dto.DefectDTO;
import com.training.internal.project.defect.controller.dto.mapper.DefectDataMapper;
import com.training.internal.project.defect.entities.Defect;
import com.training.internal.project.defect.repositories.DefectRepository;
import com.training.internal.project.defect.services.DefectService;
import com.training.internal.project.project.entities.Module;
import com.training.internal.project.project.entities.Project;
import com.training.internal.project.project.services.ModuleService;
import com.training.internal.project.project.services.ProjectService;

import org.springframework.http.HttpStatus;

import java.sql.Date;
import java.util.List;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@CrossOrigin
@RestController
public class DefectController {

	@Autowired
	private DefectDataMapper defectDataMapper;

	@Autowired
	private ModuleService moduleService;

	@Autowired
	private DefectService defectService;

	@Autowired
	private DefectRepository defectRepository;

	@Autowired
	private ProjectService projectService;

	private static Logger logger = LogManager.getLogger(DefectDataMapper.class);

	@GetMapping(value = "/getAllDefects")
	public List<DefectDTO> getAllDefects() {
		logger.info("Controller -> getAllDefects Successfull");
		return defectDataMapper.getAllDefects();
	}

	@GetMapping(value = "/getDefectById/{defectId}")
	public DefectDTO getByDefectId(@PathVariable(name = "defectId") String defectId) {
		logger.info("Controller -> getByDefectId Successfull");
		return defectDataMapper.getByDefectId(defectId);

	}

	@GetMapping(value = "/getAllDefectsByProjectId/{projectId}")
	public List<DefectDTO> getByProjectId(@PathVariable(name = "projectId") String projectId) {
		logger.info("Controller -> getByProjectId Successfull");
		return defectDataMapper.getAllDefectByProjectById(projectId);
	}

	@GetMapping(value = "/getAllDefectsByModuleId/{moduleId}")
	public List<DefectDTO> getByModuleId(@PathVariable(name = "moduleId") String moduleId) {
		logger.info("Controller -> getBymoduleId Successfull");
		return defectDataMapper.getAllDefectByModuleById(moduleId);
	}

	@GetMapping(value = "/getAllDefectsByDate/{dateAndTime}")
	public List<DefectDTO> getByDate(@PathVariable(name = "dateAndTime") Date dateAndTime) {
		logger.info("Controller -> getByDate Successfull");
		return defectDataMapper.getAllDefectByDate(dateAndTime);
	}

	@PostMapping("/saveDefect")
	public ResponseEntity<String> saveDefect(@Valid @RequestBody DefectDTO defectDTO) {
		if (defectDataMapper.createDefect(defectDTO) != null) {
			logger.info("Defect Controller -> Defects Created Successful");
			return new ResponseEntity<>("Defect added succesfully", HttpStatus.OK);
		}
		logger.info("Defect Controller -> Defects creation FAILED!!!");
		return new ResponseEntity<>("SAVE FAILED!", HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/updateDefect")
	public ResponseEntity<String> updateDefect(@RequestBody DefectDTO defectDTO) {
		logger.info("Defect Controller -> Defect Updated Successful");
		if (defectDataMapper.updateDefect(defectDTO) != null) {
			return new ResponseEntity<>("Sucessfully Updated Defect Detail", HttpStatus.OK);
		}
		logger.info("Defect Controller -> Defect Updated Failed!!!");
		return new ResponseEntity<>("Update FAILED!!!", HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/deleteDefect/{defectId}")
	public ResponseEntity<String> deleteCompany(@PathVariable(name = "defectId") String defectId) {
		System.out.print(defectId);
		if (defectDataMapper.getByDefectId(defectId) != null) {
			if (defectDataMapper.deleteDefect(defectId) == null) {
				logger.info("Defect Controller -> Defect Deleted Successful");
				return new ResponseEntity<>("Defect Sucessfully deleted", HttpStatus.OK);
			}
		} else {
			logger.info("Defect Controller -> Defect Id Not Found");
			return new ResponseEntity<>("Defect Id Not FOUND!!!", HttpStatus.BAD_REQUEST);
		}
		logger.info("Defect Controller -> Defect Deleted Failed!!!");
		return new ResponseEntity<>("Delete FAILED!!!", HttpStatus.BAD_REQUEST);
	}

	@GetMapping(value = "/getDefectsByStatus/{status}")
	public List<DefectDTO> getByStatus(@PathVariable(name = "status") String status) {
		logger.info("Controller -> getByDate Successfull");
		return defectDataMapper.getAllDefectByStatus(status);
	}

	@GetMapping(value = "/getDefectsByPriority/{priority}")
	public List<DefectDTO> getByPriority(@PathVariable(name = "priority") String priority) {
		logger.info("Controller -> getByDate Successfull");
		return defectDataMapper.getAllDefectByPriority(priority);
	}

	@GetMapping(value = "/getDefectsBySeverity/{severity}")
	public List<DefectDTO> getBySeverity(@PathVariable(name = "severity") String severity) {
		logger.info("Controller -> getByDate Successfull");
		return defectDataMapper.getAllDefectBySeverity(severity);
	}

	@GetMapping(value = "/getDefectsByType/{type}")
	public List<DefectDTO> getByType(@PathVariable(name = "type") String type) {
		logger.info("Controller -> getByDate Successfull");
		return defectDataMapper.getAllDefectByType(type);
	}

	@GetMapping(value = "/getDefectsByFixedIn/{fixedIn}")
	public List<DefectDTO> getByFixedIn(@PathVariable(name = "fixedIn") String fixedIn) {
		logger.info("Controller -> getByfixedIn Successfull");
		return defectDataMapper.getAllDefectByFixedIn(fixedIn);
	}

	@PutMapping("/defect/module/{moduleId}")
	public Defect createNewDefect(@PathVariable(name = "moduleId") String moduleId,
			@RequestBody DefectDTO defectDTO) {

		Module module = moduleService.getByModuleId(moduleId);
		List<Defect> defect = defectRepository.findDefectByModule(module);
		int def = defect.size();
		String defectSerial = moduleId + "-" + def;

		Defect defects = new Defect();

		Project project = projectService.getByprojectId(defectDTO.getProjectId());

		defects.setDefectId(defectSerial);

		defects.setProject(project);
		defects.setModule(module);
		defects.setAbbre(defectDTO.getAbbre());
		defects.setDefectDescription(defectDTO.getDefectDescription());
		defects.setStepsToRecreate(defectDTO.getStepsToRecreate());
		defects.setAssignTo(defectDTO.getAssignTo());
		defects.setReassignTo(defectDTO.getReassignTo());
		defects.setEnteredBy(defectDTO.getEnteredBy());
		defects.setFixedBy(defectDTO.getFixedBy());
		defects.setDateAndTime(defectDTO.getDateAndTime());
		defects.setAvailableIn(defectDTO.getAvailableIn());
		defects.setFoundIn(defectDTO.getFoundIn());
		defects.setFixedIn(defectDTO.getFixedIn());

		return defectRepository.save(defects);
	}

	



}