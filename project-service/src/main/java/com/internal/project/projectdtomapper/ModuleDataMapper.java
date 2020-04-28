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

	public ModuleData getByModuleId(Long mid) {
		Module module = moduleService.getByModuleId(mid);
		return ModuleConverter.moduleToModuleData(module);
		
	}
	
	public List<ModuleData> getBymoduleNameForMapper (String moduleName){
		List<Module> module = moduleService.getBymoduleName(moduleName);
		return ModuleConverter.moduleToModuleData(module);
	}
	
	public Module UpdateModule(Long mid, ModuleData moduleData) {
		Module module = ModuleConverter.moduleDataToModule(moduleData);
		return moduleService.updateModule(mid, module);
	}
	
	public ModuleData deleteById(Long mid) {
		moduleService.deleteById(mid);
		return null;
	}


}