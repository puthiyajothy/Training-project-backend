package com.internal.project.project.controller.dto.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internal.project.project.controller.converter.SubModuleConverter;
import com.internal.project.project.controller.dto.SubModuleData;
import com.internal.project.project.entities.SubModule;
import com.internal.project.project.services.SubModuleService;

@Service
public class SubModuleDataMapper {
	@Autowired
	public SubModuleService subModuleService;

	public List<SubModuleData> getAllSubModuleForMapper() {
		List<SubModule> subModuleList = subModuleService.getallDetails();
		return SubModuleConverter.subModuleToSubModuleData(subModuleList);
	}

	public SubModule saveSubModuleforMapper(SubModuleData subModuleData) {
		SubModule subModule = SubModuleConverter.subModuleDataToSubModule(subModuleData);
		return subModuleService.createSubModule(subModule);
	}

	public SubModuleData getBySubModuleId(String subModuleId) {
		SubModule subModule = subModuleService.getBySubModuleId(subModuleId);
		return SubModuleConverter.subModuleToSubModuleData(subModule);
	}

	public List<SubModuleData> getBysubModuleNameForMapper(String subModuleName) {
		List<SubModule> subModule = subModuleService.getBysubModuleName(subModuleName);
		return SubModuleConverter.subModuleToSubModuleData(subModule);

	}

	public SubModule UpdateSubModule(String subModuleId, SubModuleData subModuleData) {
		SubModule subModule = SubModuleConverter.subModuleDataToSubModule(subModuleData);
		return subModuleService.updateSubModule(subModuleId, subModule);

	}

	public void deleteSubModuleById(String subModuleId) {
		subModuleService.deleteSubModuleById(subModuleId);
		
	}
	

}