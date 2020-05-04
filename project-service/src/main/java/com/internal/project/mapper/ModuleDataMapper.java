package com.internal.project.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internal.project.converter.ModuleConverter;
import com.internal.project.dto.ModuleDto;
import com.internal.project.entities.Module;
import com.internal.project.projectservicesImpl.ModuleServiceImpl;
import com.internal.project.services.ModuleService;

@Service
public class ModuleDataMapper {
	
	@Autowired
	public  ModuleServiceImpl moduleService;
	
	public List<ModuleDto>getAllModuleForMapper(){
		List<Module>moduleList =moduleService.getallDetails();
		return ModuleConverter.moduleToModuleData(moduleList);
	}
	public Module saveModuleforMapper(ModuleDto moduleDto) {
		Module module = ModuleConverter.moduleDataToModule(moduleDto);
		return moduleService.createModule(module);
	}

	public ModuleDto getByModuleId(Long mid) {
		Module module = moduleService.getByModuleId(mid);
		return ModuleConverter.moduleToModuleDto(module);
		
	}
	
	public List<ModuleDto> getBymoduleNameForMapper (String moduleName){
		List<Module> module = moduleService.getBymoduleName(moduleName);
		return ModuleConverter.moduleToModuleData(module);
	}
	
	public Module UpdateModule(Long mid, ModuleDto moduleDto) {
		Module module = ModuleConverter.moduleDataToModule(moduleDto);
		return moduleService.updateModule(mid, module);
	}
	
	public ModuleDto deleteById(Long mid) {
		moduleService.deleteById(mid);
		return null;
	}


}