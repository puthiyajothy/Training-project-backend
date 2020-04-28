package com.internal.project.services;

import java.util.List;

import com.internal.project.entities.Module;


public interface ModuleService {

	public Module createModule(Module module);

	public boolean isModuleAlreadyExists(Long mid);

	public List<Module> getallDetails();

//	public List<Object> getSubmodule(Long projectId);
	
	public void deleteById(Long mid);

	public Module updateModule(Long mid, Module module);

	public Module getByModuleId(Long mid);

	public List<Module> getBymoduleName(String moduleName);

	

}
