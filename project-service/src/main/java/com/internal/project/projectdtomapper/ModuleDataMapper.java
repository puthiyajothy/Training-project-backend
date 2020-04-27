package com.internal.project.projectdtomapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internal.project.converter.ModuleConverter;
import com.internal.project.project.entities.Module;
import com.internal.project.project.services.ModuleService;
import com.internal.project.projectdto.ModuleData;

@Service
public class ModuleDataMapper {
	
	@Autowired
	public  ModuleService moduleService;
	
	public List<ModuleData>getAllModuleForMapper(){
		List<Module>moduleList =moduleService.getallDetails();
		return ModuleConverter.moduleToModuleData(moduleList);
	}
	public Module saveModuleforMapper(ModuleData moduleData) {
		Module module = ModuleConverter.moduleDataToModule(moduleData);
		return moduleService.createModule(module);
	}
//	public List<ModuleData> getAllSubmoduleForMapper(String projectid){
//		List<Module>moduleList =moduleService.getSubmodule(projectid);
//		return ModuleConverter.moduleToModuleData(moduleList);
//	}
	public ModuleData getByModuleId(String moduleId) {
		Module module = moduleService.getByModuleId(moduleId);
		return ModuleConverter.moduleToModuleData(module);
		
	}
	
	public List<ModuleData> getBymoduleNameForMapper (String moduleName){
		List<Module> module = moduleService.getBymoduleName(moduleName);
		return ModuleConverter.moduleToModuleData(module);
	}
	
	public Module UpdateModule(String moduleId, ModuleData moduleData) {
		Module module = ModuleConverter.moduleDataToModule(moduleData);
		return moduleService.updateModule(moduleId, module);
	}
	
	public ModuleData deleteById(String moduleId) {
		moduleService.deleteById(moduleId);
		return null;
	}


}