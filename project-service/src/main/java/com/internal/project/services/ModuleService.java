package com.internal.project.services;

import java.util.List;

import com.internal.project.entities.Module;


public interface ModuleService {

	public Module createModule(Module module);

	public boolean isModuleAlreadyExists(Long mid);

	public List<Module> getallDetails();

//	public List<Object> getSubmodule(String projectid);
	
	

	public void deleteById(Long mid);

	public Module updateModule(Long mid, Module module);

	Module getByModuleId(Long mid);

	public List<Module> getBymoduleName(String moduleName);

	// service for get project id
//	public List<Module> getBypid(Long pid);

//	List<Object> getSubmodule(String subModuleId);

	// service for submodule id
//	public List<Module> getBySubModuleId(String subModuleId);

}
