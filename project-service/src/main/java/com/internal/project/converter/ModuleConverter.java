package com.internal.project.converter;

import java.util.ArrayList;
import java.util.List;

import com.internal.project.dto.ModuleDto;
import com.internal.project.entities.Module;
import com.internal.project.entities.Project;

public class ModuleConverter {
	
	public static ModuleDto moduleToModuleDto(Module module) {
		ModuleDto moduleDto = new ModuleDto();

		if (module != null) {
			moduleDto.setMid(module.getMid());
			moduleDto.setModuleId(module.getModuleId());
			moduleDto.setModuleName(module.getModuleName());
			moduleDto.setProjectid(module.getProject().getProjectId());
			moduleDto.setProjectName(module.getProject().getProjectName());
			return moduleDto;
		}
		return null;
	}
	
	public static Module moduleDataToModule(ModuleDto moduleDto) {
		Module module = new Module(); 
		module.setModuleId(moduleDto.getModuleId());
		module.setModuleName(moduleDto.getModuleName());
		Project project = new Project();
		project.setProjectId(moduleDto.getProjectid());
		project.setProjectName(moduleDto.getProjectName());
		module.setProject(project);
		
		
		return module;
	}
	
	public static List<ModuleDto> moduleToModuleData(List<Module> moduleList) {

		if (moduleList != null) {
			List<ModuleDto> lModuleData = new ArrayList<>();
			for (Module module : moduleList) {
				ModuleDto moduleDto = new ModuleDto();
				
				moduleDto.setModuleId(module.getModuleId());
				moduleDto.setModuleName(module.getModuleName());
				moduleDto.setProjectid(module.getProject().getProjectId());
				moduleDto.setProjectName(module.getProject().getProjectName());
		
				
				
			}

			return lModuleData;
		}
		return null;

	}


}
