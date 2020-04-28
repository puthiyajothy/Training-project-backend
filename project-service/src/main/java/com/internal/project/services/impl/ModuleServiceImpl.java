package com.internal.project.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internal.project.project.entities.Module;
import com.internal.project.project.repositories.ModuleRepository;
import com.internal.project.project.services.ModuleService;

@Service
public class ModuleServiceImpl implements ModuleService {

	@Autowired
	private ModuleRepository moduleRepository;

	@Override
	public Module createModule(Module module) {
		Module responseModule = moduleRepository.save(module);
		return responseModule;
	}

	@Override
	public void deleteById(Long mid) {
		moduleRepository.deleteById(mid);

	}

	@Override
	public Module getByModuleId(Long mid) {
		return moduleRepository.getByModuleId(mid);
	}


	@Override
	public List<Module> getallDetails() {
		return moduleRepository.findAll();
	}

	@Override
	public Module updateModule(Long mid, Module module) {
		if (moduleRepository.findAll() != null) {
			module.setMid(mid);
			moduleRepository.save(module);
		}
		return module;
	}

	@Override
	public boolean isModuleAlreadyExists(Long mid) {
		return moduleRepository.existsById(mid);
	}

	@Override
	public List<Module> getBypid(Long pid) {
		return moduleRepository.getByPid(pid);
	}

//	@Override
//	public List<Object> getSubmodule(String subModuleId) {
//		return moduleRepository.getSubmodule(subModuleId);
//	}

	@Override
	public List<Module> getBymoduleName(String moduleName) {
		return moduleRepository.getBymoduleName(moduleName);
	}

}
