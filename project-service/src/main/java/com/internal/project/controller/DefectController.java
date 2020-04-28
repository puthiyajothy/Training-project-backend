//package com.internal.project.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.internal.project.dto.DefectDTO;
//import com.internal.project.entities.Defect;
//import com.internal.project.entities.Module;
//import com.internal.project.entities.Project;
//import com.internal.project.mapper.DefectDTOMapper;
//import com.internal.project.repositories.DefectRepository;
//import com.internal.project.services.DefectService;
//import com.internal.project.services.ModuleService;
//import com.internal.project.services.ProjectService;
//
//import org.springframework.http.HttpStatus;
//
//import java.sql.Date;
//import java.util.List;
//import javax.validation.Valid;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//@CrossOrigin
//@RestController
//public class DefectController {
//
//	@Autowired
//	private DefectDTOMapper defectDTOMapper;
//
//	@Autowired
//	private ModuleService moduleService;
//
//	@Autowired
//	private DefectService defectService;
//
////	@Autowired
////	private ProjectService projectService;
//
//	@Autowired
//	DefectRepository defectRepository;
//	
//	private static Logger logger = LogManager.getLogger(DefectDTOMapper.class);
//
//	@PostMapping("/saveDefect")
//	public ResponseEntity<String> saveDefect(@Valid @RequestBody DefectDTO defectDTO) {
//		try {
//			if (defectDTOMapper.createDefect(defectDTO) != null) {
//				logger.info("Defect Controller -> Defects Created Successful");
//				return new ResponseEntity<>("Defect added succesfully", HttpStatus.OK);
//			}
//		} catch (Exception e) {
//			logger.info("Controller -> getAllDefects FAILD" + e.getMessage());
//			return new ResponseEntity<>("SAVE FAILED!", HttpStatus.BAD_REQUEST);
//		}
//		return null;
//	}
//
//	@GetMapping(value = "/getAllDefects")
//	public List<DefectDTO> getAllDefects() {
//		try {
//			logger.info("Controller -> getAllDefects Successfull");
//			return defectDTOMapper.getAllDefects();
//		} catch (Exception e) {
//			logger.info("Controller -> getAllDefects Successfull" + e.getMessage());
//
//		}
//		return null;
//
//	}
//
//	@GetMapping(value = "/getDefectById/{defid}")
//	public DefectDTO getByDefectId(@PathVariable(name = "defd") Long defid) {
//		try {
//			logger.info("Controller -> getByDefectId Successfull");
//			return defectDTOMapper.getByDefectId(defid);
//		} catch (Exception e) {
//			logger.info("Controller -> delete FAILD" + e.getMessage());
//		}
//		return null;
//
//	}
//
//	@GetMapping(value = "/getAllDefectsByProjectId/{pid}")
//	public List<DefectDTO> getByProjectId(@PathVariable(name = "pid") Long pid) {
//		try {
//			logger.info("Controller -> getByProjectId Successfull");
//			return defectDTOMapper.getAllDefectByProjectById(pid);
//		} catch (Exception e) {
//			logger.info("Controller -> Faild" + e.getMessage());
//		}
//		return null;
//
//	}
//
//	@GetMapping(value = "/getAllDefectsByModuleId/{mid}")
//	public List<DefectDTO> getByModuleId(@PathVariable(name = "moduleId") Long mid) {
//		try {
//			logger.info("Controller -> getBymoduleId Successfull");
//			return defectDTOMapper.getAllDefectByModuleById(mid);
//
//		} catch (Exception e) {
//			logger.info("Controller -> Faild" + e.getMessage());
//		}
//		return null;
//	}
//
//	@GetMapping(value = "/getAllDefectsByDate/{dateAndTime}")
//	public List<DefectDTO> getByDate(@PathVariable(name = "dateAndTime") Date dateAndTime) {
//		try {
//			logger.info("Controller -> getByDate Successfull");
//			return defectDTOMapper.getAllDefectByDate(dateAndTime);
//		} catch (Exception e) {
//			logger.info("Controller -> Faild" + e.getMessage());
//		}
//		return null;
//
//	}
//
//	@PutMapping("/updateDefect")
//	public ResponseEntity<String> updateDefect(@RequestBody DefectDTO defectDTO) {
//		try {
//			logger.info("Defect Controller -> Defect Updated Successful");
//			if (defectDTOMapper.updateDefect(defectDTO) != null) {
//				return new ResponseEntity<>("Sucessfully Updated Defect Detail", HttpStatus.OK);
//			}
//		} catch (Exception e) {
//			logger.info("Defect Controller -> Defect Updated Failed!!!");
//			return new ResponseEntity<>("Update FAILED!!!", HttpStatus.BAD_REQUEST);
//		}
//		return null;
//
//	}
//
//	@DeleteMapping("/deleteDefect/{defid}")
//	public ResponseEntity<String> delete(@PathVariable(name = "defid") Long defid) {
//		try {
//			System.out.print(defid);
//			if (defectDTOMapper.getByDefectId(defid) != null) {
//				if (defectDTOMapper.deleteDefect(defid) == null) {
//					logger.info("Defect Controller -> Defect Deleted Successful");
//					return new ResponseEntity<>("Defect Sucessfully deleted", HttpStatus.OK);
//				}
//			} else {
//				logger.info("Defect Controller -> Defect Id Not Found");
//				return new ResponseEntity<>("Defect Id Not FOUND!!!", HttpStatus.BAD_REQUEST);
//			}
//
//		} catch (Exception e) {
//			logger.info("Defect Controller -> Defect Deleted Failed!!!" + e.getMessage());
//			return new ResponseEntity<>("Delete FAILED!!!", HttpStatus.BAD_REQUEST);
//		}
//		return null;
//
//	}
//
//	@GetMapping(value = "/getDefectsByStatus/{status}")
//	public List<DefectDTO> getByStatus(@PathVariable(name = "status") String status) {
//		try {
//			logger.info("Controller -> getByDate Successfull");
//			return defectDTOMapper.getAllDefectByStatus(status);
//		} catch (Exception e) {
//			logger.info("Failed!!!" + e.getMessage());
//		}
//		return null;
//
//	}
//
//	@GetMapping(value = "/getDefectsByPriority/{priority}")
//	public List<DefectDTO> getByPriority(@PathVariable(name = "priority") String priority) {
//		logger.info("Controller -> getByDate Successfull");
//		return defectDTOMapper.getAllDefectByPriority(priority);
//	}
//
//	@GetMapping(value = "/getDefectsBySeverity/{severity}")
//	public List<DefectDTO> getBySeverity(@PathVariable(name = "severity") String severity) {
//		logger.info("Controller -> getByDate Successfull");
//		return defectDTOMapper.getAllDefectBySeverity(severity);
//	}
//
//	@GetMapping(value = "/getDefectsByType/{type}")
//	public List<DefectDTO> getByType(@PathVariable(name = "type") String type) {
//		logger.info("Controller -> getByDate Successfull");
//		return defectDTOMapper.getAllDefectByType(type);
//	}
//
//	@GetMapping(value = "/getDefectsByAvailableIn/{availableIn}")
//	public List<DefectDTO> getByAvailableIn(@PathVariable(name = "availableIn") String availableIn) {
//		logger.info("Controller -> getByDate Successfull");
//		return defectDTOMapper.getAllDefectByAvailableIn(availableIn);
//	}
//
//	@GetMapping(value = "/getDefectsByFoundIn/{foundIn}")
//	public List<DefectDTO> getByFoundIn(@PathVariable(name = "foundIn") String foundIn) {
//		logger.info("Controller -> getByfoundIn Successfull");
//		return defectDTOMapper.getAllDefectByFoundIn(foundIn);
//	}
//
//	@GetMapping(value = "/getDefectsByFixedIn/{fixedIn}")
//	public List<DefectDTO> getByFixedIn(@PathVariable(name = "fixedIn") String fixedIn) {
//		logger.info("Controller -> getByfixedIn Successfull");
//		return defectDTOMapper.getAllDefectByFixedIn(fixedIn);
//	}
//
//	@GetMapping(value = "/getMockDefect")
//	public DefectDTO getMockDefect() {
//		return new DefectDTO();
//	}
//
//	@GetMapping(value = "/getCount")
//	public Long getCount() {
//		return defectService.countDefect();
//
//	}
//
//	@GetMapping(value = "/getDefectDensity")
//	public double getDefectDensity() {
//		return defectService.countDefectDensity();
//
//	}
//
//	// Create defect service
//	@PutMapping("/defect/module/{mid}")
//	public Defect createNewDefect(@PathVariable(name = "mid") Long mid, @RequestBody DefectDTO defectDTO) {
//
//		Module module = moduleService.getByModuleId(mid);
//		List<Defect> defect = defectRepository.findDefectByModule(module);
//		int def = defect.size();
//		String defectSerial = mid + "-" + def;
//
//		Defect defects = new Defect();
//
////		Project project = projectService.getByprojectId(defectDTO.getProjectId());
//
//		defects.setDefectId(defectSerial);
//
////		defects.setProject(project);
//		defects.setModule(module);
////		defects.setAbbre(defectDTO.getAbbre());
//		defects.setDefectDescription(defectDTO.getDefectDescription());
//		defects.setStepsToRecreate(defectDTO.getStepsToRecreate());
//		defects.setAssignTo(defectDTO.getAssignTo());
//		defects.setReassignTo(defectDTO.getReassignTo());
//		defects.setEnteredBy(defectDTO.getEnteredBy());
//		defects.setFixedBy(defectDTO.getFixedBy());
//		defects.setDateAndTime(defectDTO.getDateAndTime());
//		defects.setAvailableIn(defectDTO.getAvailableIn());
//		defects.setFoundIn(defectDTO.getFoundIn());
//		defects.setFixedIn(defectDTO.getFixedIn());
//
//		return defectRepository.save(defects);
//	}
//
//	@GetMapping(value = "/getStatusNew")
//	public Long getStatusNew() {
//		return defectService.getStatusNew();
//	}
//
//	@GetMapping(value = "/getStatusOpen")
//	public Long getStatusOpen() {
//		return defectService.getStatusOpen();
//	}
//
//	@GetMapping(value = "/getStatusClose")
//	public Long getStatusClose() {
//		return defectService.getStatusClose();
//	}
//
//	@GetMapping(value = "/getStatusRejected")
//	public Long getStatusRejected() {
//		return defectService.getStatusRejected();
//	}
//
//	@GetMapping(value = "/getStatusReOpen")
//	public Long getStatusReOpen() {
//		return defectService.getStatusReOpen();
//	}
//
//	@GetMapping(value = "/getStatusFixed")
//	public Long getStatusFixed() {
//		return defectService.getStatusFixed();
//	}
//
//	@GetMapping(value = "/getStatusDefered")
//	public Long getStatusDefered() {
//		return defectService.getStatusDefered();
//	}
//
//}
