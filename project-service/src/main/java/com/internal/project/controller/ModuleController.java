//package com.internal.project.controller;
//
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
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
//import org.springframework.http.HttpStatus;
//
//import com.internal.project.dto.ModuleData;
//import com.internal.project.entities.Module;
//import com.internal.project.mapper.ModuleDataMapper;
//import com.internal.project.repositories.ModuleRepository;
//import com.internal.project.services.ModuleService;
//import com.internal.project.services.ProjectService;
//
//@CrossOrigin
//@RestController
//public class ModuleController {
//
//	private static Logger logger = LogManager.getLogger(ModuleRepository.class);
//
//	@Autowired
//	public ModuleDataMapper moduleDataMapper;
//
//	@Autowired
//	public ProjectService projectService;
//
//	@Autowired
//	public ModuleRepository moduleRepository;
//
//	@Autowired
//	public ModuleService moduleService;
//
//	@PostMapping(value = "/createmodule")
//	public ResponseEntity<Object> createModule(@Valid @RequestBody ModuleData moduleData) {
//		try {
//			moduleDataMapper.saveModuleforMapper(moduleData);
//
//		} catch (Exception e) {
//			logger.info("Controller -> Faild" + e.getMessage());
//
//		}
//		return null;
//
//	}
//
//	// Get Mapping For Get All Module
//	@GetMapping(value = "/GetAllmodule")
//	public ResponseEntity<List<ModuleData>> listModuleInfo() {
//		logger.info("Module are listed ");
//		return new ResponseEntity<>(moduleDataMapper.getAllModuleForMapper(), HttpStatus.OK);
//	}
//
////	// Get All By Project Id //
////	@GetMapping(value = "/GetAllmodule/{pid}")
////	public List<Module> getModuleByProjectId(@PathVariable Long pid) {
////		logger.info("Module are listed ");
////		return moduleService.getBypid(pid);
////	}
//
//	// Get All Details in module Table
//	@GetMapping("/FindallMain")
//	public List<Module> FindallMain(Module module) {
//		List<Module> submodule = (List<Module>) moduleService.getallDetails();
//		return submodule;
//	}
//
////	@GetMapping("/findProject")
////	public  List<Project> findallmain(Project project) {
////		 List<Project> moduless = (List<Project>) projectservice.findAll();
////		 return moduless;
////	        	
////	}
////	@GetMapping(value = "/GetAllmodulesubmodule/{projectid}")
////	public ResponseEntity<List<Object>> getModuleBySubModuleId(@PathVariable String projectid) {
////		logger.info("Module are listed ");
////		return new ResponseEntity<>(moduleService.getSubmodule(projectid), HttpStatus.OK);
////	}
//
//	// Get Mapping For Get Module By Id
//	@GetMapping("/GetmoduleById/{mid}")
//	public ResponseEntity<ModuleData> getModuleById(@PathVariable Long mid) {
//		logger.info("Module are get by id ");
//		return new ResponseEntity<>(moduleDataMapper.getByModuleId(mid), HttpStatus.OK);
//	}
//
//	// Get Mapping For Module Name
//	@GetMapping("/getModuleName/{moduleName}")
//	public List<ModuleData> getBymoduleName(@PathVariable String moduleName) {
//		logger.info("Module are get by name ");
//		return moduleDataMapper.getBymoduleNameForMapper(moduleName);
//	}
//
//	// Delete Mapping For Module
//	@DeleteMapping("deleteModuleById/{mid}")
//	public void deleteById(@PathVariable Long mid) {
//		logger.info("Module are delete by id ");
//		moduleDataMapper.deleteById(mid);
//
//	}
//
//	// Put Mapping For Module
//	@PutMapping("/updateModule/{mid}")
//	public ResponseEntity<String> updateModule(@Valid @PathVariable(name = "mid") Long mid,
//			@RequestBody ModuleData moduleData) {
//		logger.info("Modulecontroller -> updatedModule");
//		if (moduleDataMapper.UpdateModule(mid, moduleData) != null)
//			;
//		{
//			return new ResponseEntity<>("ok", HttpStatus.OK);
//		}
//	}
//
//	// Abbreviation for module
////	@PutMapping("/module/project/{pid}")
////	public Module createNewModule(@PathVariable(name = "pid") Long pid, @RequestBody ModuleData moduleData) {
////		Project project = projectService.getByprojectId(pid);
////		List<Module> modules = moduleRepository.findModuleByProject(project);
////		int a = modules.size();
////		String moduleSerial = project.getProjectId() + "-" + moduleData.getModuleId() + "-" + a;
////
////		Module module = new Module();
////		module.setModuleId(moduleSerial);
////		module.setModuleName(moduleData.getModuleName());
////		module.setProject(project);
//
////		return moduleRepository.save(module);
//
////	}
//
//}
