package com.internal.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import org.springframework.http.HttpStatus;

import com.internal.project.dto.ModuleDto;
import com.internal.project.dto.ProjectDto;
import com.internal.project.entities.Module;
import com.internal.project.mapper.ModuleDataMapper;
import com.internal.project.repositories.ModuleRepository;
import com.internal.project.services.ModuleService;
import com.internal.project.services.ProjectService;

@CrossOrigin
@RestController
public class ModuleController {

	private static Logger logger = LogManager.getLogger(ModuleRepository.class);

	@Autowired
	public ModuleDataMapper moduleDataMapper;

	@Autowired
	public ProjectService projectService;

	@Autowired
	public ModuleRepository moduleRepository;

	@Autowired
	public ModuleService moduleService;

	
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
	@PostMapping(value = "/createmodule")
	public ResponseEntity<Object> createmodule(@Valid @RequestBody Module module) {
		try {
			moduleRepository.save(module);
			logger.info("Project created");
		} catch (Exception e) {
			logger.info("Project Controller ---> Error" + e.getMessage());
		}

		return null;
	}

	// Get Mapping For Get All Module
	@GetMapping(value = "/GetAllmodule")
	public ResponseEntity<List<ModuleDto>> listModuleInfo() {
		logger.info("Module are listed ");
		return new ResponseEntity<>(moduleDataMapper.getAllModuleForMapper(), HttpStatus.OK);
	}

	// Get All Details in module Table
	@GetMapping("/FindallMain")
	public List<Module> FindallMain(Module module) {
		List<Module> submodule = (List<Module>) moduleService.getallDetails();
		return submodule;
	}

	// Get Mapping For Get Module By Id
	@GetMapping("/GetmoduleById/{mid}")
	public ResponseEntity<ModuleDto> getModuleById(@PathVariable Long mid) {
		logger.info("Module are get by id ");
		return new ResponseEntity<>(moduleDataMapper.getByModuleId(mid), HttpStatus.OK);
	}

	// Get Mapping For Module Name
	@GetMapping("/getModuleName/{moduleName}")
	public List<ModuleDto> getBymoduleName(@PathVariable String moduleName) {
		logger.info("Module are get by name ");
		return moduleDataMapper.getBymoduleNameForMapper(moduleName);
	}

	// Delete Mapping For Module
	@DeleteMapping("deleteModuleById/{mid}")
	public void deleteById(@PathVariable Long mid) {
		logger.info("Module are delete by id ");
		moduleDataMapper.deleteById(mid);

	}

	// Put Mapping For Module
	@PutMapping("/updateModule/{mid}")
	public ResponseEntity<String> updateModule(@Valid @PathVariable(name = "mid") Long mid,
			@RequestBody ModuleDto moduleDto) {
		logger.info("Modulecontroller -> updatedModule");
		if (moduleDataMapper.UpdateModule(mid, moduleDto) != null)
			;
		{
			return new ResponseEntity<>("ok", HttpStatus.OK);
		}
	}

	// Abbreviation for module
//	@PutMapping("/module/project/{pid}")
//	public Module createNewModule(@PathVariable(name = "pid") Long pid, @RequestBody ModuleData moduleData) {
//		Project project = projectService.getByprojectId(pid);
//		List<Module> modules = moduleRepository.findModuleByProject(project);
//		int a = modules.size();
//		String moduleSerial = project.getProjectId() + "-" + moduleData.getModuleId() + "-" + a;
//
//		Module module = new Module();
//		module.setModuleId(moduleSerial);
//		module.setModuleName(moduleData.getModuleName());
//		module.setProject(project);

//		return moduleRepository.save(module);

//	}

}
